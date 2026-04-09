package ru.stvvllrt.course_app.domain.appdetails

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAppDetailsUseCase @Inject constructor(
    private val repository: AppDetailsRepository
) {
    suspend operator fun invoke(id: String) = repository.getAppDetails(id)

    fun observeAppDetails(id: String): Flow<AppDetails> = repository.observeAppDetails(id)

    suspend fun toggleWishlist(id: String) = repository.toggleWishlist(id)
}