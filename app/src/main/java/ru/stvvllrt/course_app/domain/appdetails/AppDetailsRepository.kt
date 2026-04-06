package ru.stvvllrt.course_app.domain.appdetails


interface AppDetailsRepository {
    suspend fun getAppDetails(appId: String): AppDetails
}