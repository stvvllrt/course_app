package ru.stvvllrt.course_app.domain.applist

data class AppList(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val icon: String
)