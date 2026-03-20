package ru.stvvllrt.course_app.data.applist

import ru.stvvllrt.course_app.domain.applist.AppListRepository
import ru.stvvllrt.course_app.domain.applist.AppList

class AppListRepositoryImpl : AppListRepository {
    private val appListApi = AppListApi()
    private val mapper = AppListMapper()

    override suspend fun get(): List<AppList> {
        val dto = appListApi.get()
        val domain = dto.map { mapper.toDomain(it) }
        return domain
    }
}