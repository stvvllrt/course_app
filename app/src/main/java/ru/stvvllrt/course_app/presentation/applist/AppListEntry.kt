package ru.stvvllrt.course_app.presentation.applist

import androidx.compose.runtime.Immutable

@Immutable
data class AppListEntry(
    val name: String,
    val icon: String,
    val category: String,
    val description: String
)

