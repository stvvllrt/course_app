package ru.stvvllrt.course_app.data.appdetails

import ru.stvvllrt.course_app.domain.appdetails.Category

data class AppDetailsDto(
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Double,
    val icon: String,
    val screenshots: List<String>,
    val description: String,
)