package ru.stvvllrt.course_app.presentation.appdetails

import androidx.compose.runtime.Immutable
import ru.stvvllrt.course_app.domain.appdetails.AppDetails

@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: AppDetails,
        val descriptionCollapsed: Boolean,
        val isInWishlist: Boolean,
    ) : AppDetailsState
}