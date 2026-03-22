package ru.stvvllrt.course_app.data.appdetails

import ru.stvvllrt.course_app.domain.appdetails.AppDetails
import ru.stvvllrt.course_app.domain.appdetails.AppDetailsRepository

class AppDetailsRepositoryImpl : AppDetailsRepository {
    private val appApi = AppApi()
    private val mapper = AppDetailsMapper()

    override suspend fun get(): AppDetails {
        val dto = appApi.get()
        val domain = mapper.toDomain(dto)
        return domain
    }
}