package ru.stvvllrt.course_app.domain.applist

import ru.stvvllrt.course_app.domain.appdetails.AppDetails
import ru.stvvllrt.course_app.domain.appdetails.AppDetailsRepository
import ru.stvvllrt.course_app.domain.appdetails.Category

class GetAppListUseCase(
    private val appListRepository: AppListRepository,
) {
    suspend operator fun invoke(): List<AppList> {
        val app: List<AppList> = appListRepository.get()

        return app
    }
}