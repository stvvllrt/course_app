package ru.stvvllrt.course_app.domain.appdetails

import ru.stvvllrt.course_app.domain.appdetails.AppDetailsRepository
import ru.stvvllrt.course_app.domain.appdetails.Category

class GetAppDetailsUseCase(
    private val appDetailsRepository: AppDetailsRepository,
) {
    suspend operator fun invoke(): AppDetails {
        val app: AppDetails = appDetailsRepository.get()

        if (app.category == Category.GAME) {
            throw IllegalStateException()
        }

        return app
    }
}