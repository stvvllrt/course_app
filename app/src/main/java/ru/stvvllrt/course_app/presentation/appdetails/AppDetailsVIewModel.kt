package ru.stvvllrt.course_app.presentation.appdetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.stvvllrt.course_app.domain.appdetails.GetAppDetailsUseCase
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val getAppDetailsUseCase: GetAppDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _events = Channel<AppDetailsEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    init {
        val appId: String? = savedStateHandle["appId"]
        if (appId != null) {
            viewModelScope.launch {
                _state.value = AppDetailsState.Loading

                runCatching {
                    getAppDetailsUseCase(appId)
                }.onSuccess { data ->
                    _state.value = AppDetailsState.Content(
                        appDetails = data,
                        descriptionCollapsed = true
                    )
                }.onFailure {
                    Log.e("AppDetailsViewModel", "Error loading app details")
                    _state.value = AppDetailsState.Error
                }
            }
        } else {
            _state.value = AppDetailsState.Error
        }
    }

    fun showUnderDevelopmentMessage() {
        viewModelScope.launch {
            _events.send(AppDetailsEvent.UnderDevelopment)
        }
    }

    fun collapseDescription() {
        _state.update { currentState ->
            if (currentState is AppDetailsState.Content) {
                currentState.copy(descriptionCollapsed = !currentState.descriptionCollapsed)
            } else {
                currentState
            }
        }
    }
}