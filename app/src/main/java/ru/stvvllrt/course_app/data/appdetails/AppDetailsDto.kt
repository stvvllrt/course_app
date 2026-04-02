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
/*
data class AppDetailsDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("developer") val developer: String,
    @SerializedName("category") val category: String,
    @SerializedName("ageRating") val ageRating: Int,
    @SerializedName("size") val size: Float,
    @SerializedName("iconUrl") val icon: String,
    @SerializedName("screenshotUrlList") val screenshots: List<String>,
    @SerializedName("description") val description: String
)
 */