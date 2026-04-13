package ru.stvvllrt.course_app.domain.appdetails

import kotlinx.coroutines.flow.Flow

interface AppDetailsRepository {
    suspend fun getAppDetails(appId: String): AppDetails
    fun observeAppDetails(id: String): Flow<AppDetails>
    suspend fun toggleWishlist(id: String)
}