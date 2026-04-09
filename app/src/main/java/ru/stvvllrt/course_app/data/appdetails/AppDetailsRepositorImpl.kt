package ru.stvvllrt.course_app.data.appdetails

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.stvvllrt.course_app.data.appdetails.local.AppDetailsEntityMapper
import ru.stvvllrt.course_app.data.appdetails.local.AppDetailsDao
import ru.stvvllrt.course_app.data.applist.AppListApi
import ru.stvvllrt.course_app.domain.appdetails.AppDetails
import ru.stvvllrt.course_app.domain.appdetails.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val appApi: AppListApi,
    private val mapper: AppDetailsMapper,
    private val appDetailsDao: AppDetailsDao,
    private val entityMapper: AppDetailsEntityMapper
) : AppDetailsRepository {
    override suspend fun getAppDetails(appId: String): AppDetails {
        val cachedApp = withContext(Dispatchers.IO) {
            appDetailsDao.getAppDetails(appId)
        }
        if (cachedApp != null) {
            return entityMapper.toDomain(cachedApp)
        }

        val dto = appApi.getAppDetails(appId)
        val domain = mapper.toDomain(dto)
        withContext(Dispatchers.IO) {
            appDetailsDao.insertAppDetails(entityMapper.toEntity(domain))
        }
        return domain
    }

    override fun observeAppDetails(id: String): Flow<AppDetails> {
        return appDetailsDao.observeAppDetails(id)
            .filterNotNull()
            .map { entityMapper.toDomain(it) }
    }

    override suspend fun toggleWishlist(id: String) {
        withContext(Dispatchers.IO) {
            val currentEntity = appDetailsDao.getAppDetails(id)
            currentEntity?.let {
                appDetailsDao.updateWishlistStatus(id, !it.isInWishlist)
            }
        }
    }
}