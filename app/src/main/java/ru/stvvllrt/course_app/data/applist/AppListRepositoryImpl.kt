package ru.stvvllrt.course_app.data.applist

import ru.stvvllrt.course_app.domain.applist.AppListRepository
import ru.stvvllrt.course_app.domain.applist.AppList
import javax.inject.Inject

class AppListRepositoryImpl @Inject constructor(
    private val api: AppListApi
) : AppListRepository {
    override suspend fun getAppList(): List<AppList> {
        return api.getApps().map { dto ->
            AppList(
                id = dto.id,
                name = dto.name,
                description = dto.description,
                category = dto.category,
                icon = dto.icon
            )
        }
    }
}