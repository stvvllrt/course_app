package ru.stvvllrt.course_app.domain.appdetails

import ru.stvvllrt.course_app.data.local.Data

interface AppDetailsRepository {
    suspend fun get(): AppDetails
}