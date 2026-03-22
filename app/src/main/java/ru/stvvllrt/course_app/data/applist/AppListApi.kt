package ru.stvvllrt.course_app.data.applist

import kotlinx.coroutines.delay
import ru.stvvllrt.course_app.data.local.Data.Apps
import ru.stvvllrt.course_app.data.local.Data.MTSIcon
import ru.stvvllrt.course_app.data.local.Data.MailIcon
import ru.stvvllrt.course_app.data.local.Data.SberIcon
import ru.stvvllrt.course_app.data.local.Data.YandexIcon
import ru.stvvllrt.course_app.data.local.Data.YandexMapsIcon
import ru.stvvllrt.course_app.data.local.Data.YandexMarketIcon
import ru.stvvllrt.course_app.data.appdetails.AppDetailsDto
import ru.stvvllrt.course_app.data.local.Data
import ru.stvvllrt.course_app.domain.appdetails.Category
import kotlin.time.Duration.Companion.seconds

class AppListApi {
    suspend fun get(): List<AppListDto> {
        delay(2.seconds)
        return Data.appList.map {
            AppListDto(
                name = it.name,
                category = it.category,
                icon = it.icon,
                description = it.description
            )
        }
    }
}
