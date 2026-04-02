package ru.stvvllrt.course_app.domain.applist

import javax.inject.Inject

class GetAppListUseCase @Inject constructor(
    private val repository: AppListRepository
) {
    suspend operator fun invoke(): List<AppList> = repository.getAppList()
}