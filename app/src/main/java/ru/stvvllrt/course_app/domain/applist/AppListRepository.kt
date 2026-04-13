package ru.stvvllrt.course_app.domain.applist

import ru.stvvllrt.course_app.domain.appdetails.AppDetails

interface AppListRepository {
    suspend fun getAppList(): List<AppList>

}