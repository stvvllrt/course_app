package ru.stvvllrt.course_app.presentation.applist

import androidx.compose.runtime.Immutable

@Immutable
sealed interface AppListState {
    data object Error: AppListState
    data object Loading: AppListState
    data class Content(
        val appList: List<AppListEntry>
    ): AppListState
}