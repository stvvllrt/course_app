package ru.stvvllrt.course_app.domain.applist

interface AppListRepository {
    suspend fun get() : List<AppList>
}