package ru.stvvllrt.course_app.domain.applist

interface AppListRepository {
    suspend fun getAppList(): List<AppList>
}