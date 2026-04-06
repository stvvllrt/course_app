package ru.stvvllrt.course_app.domain.appdetails

import ru.stvvllrt.course_app.domain.appdetails.AppDetailsRepository
import javax.inject.Inject

class GetAppDetailsUseCase @Inject constructor(
    private val repository: AppDetailsRepository
) {
    suspend operator fun invoke(id: String) = repository.getAppDetails(id)
}