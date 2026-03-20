package ru.stvvllrt.course_app.domain.appdetails

import ru.stvvllrt.course_app.domain.appdetails.Category

data class AppDetails(
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String,
)