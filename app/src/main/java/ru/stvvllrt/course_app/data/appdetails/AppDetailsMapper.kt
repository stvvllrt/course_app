package ru.stvvllrt.course_app.data.appdetails

import ru.stvvllrt.course_app.domain.appdetails.AppDetails

class AppDetailsMapper {
    fun toDomain(dto: AppDetailsDto): AppDetails = AppDetails(
        name = dto.name,
        developer = dto.developer,
        category = dto.category,
        ageRating = dto.ageRating,
        size = dto.size.toFloat(),
        iconUrl = dto.icon,
        screenshotUrlList = dto.screenshots,
        description = dto.description,
    )
}