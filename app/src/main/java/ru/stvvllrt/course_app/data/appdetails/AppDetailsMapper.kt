package ru.stvvllrt.course_app.data.appdetails

import ru.stvvllrt.course_app.domain.appdetails.AppDetails
import javax.inject.Inject

class AppDetailsMapper @Inject constructor() {
    fun toDomain(dto: AppDetailsDto): AppDetails = AppDetails(
        id = dto.id,
        name = dto.name,
        developer = dto.developer,
        category = dto.category,
        ageRating = dto.ageRating,
        size = dto.size.toFloat(),
        iconUrl = dto.icon,
        screenshotUrlList = dto.screenshots,
        description = dto.description,
        isInWishlist = false,
    )
}