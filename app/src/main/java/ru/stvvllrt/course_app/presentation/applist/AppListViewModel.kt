package ru.stvvllrt.course_app.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.stvvllrt.course_app.data.applist.AppListRepositoryImpl
import ru.stvvllrt.course_app.domain.applist.AppListRepository
import ru.stvvllrt.course_app.domain.applist.GetAppListUseCase
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val repository: AppListRepository,
    private val mapper: AppListDomainToUiMapper)
    : ViewModel() {
    private val getAppListUseCase = GetAppListUseCase(
        appListRepository = AppListRepositoryImpl(),
    )

    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state = _state.asStateFlow()

    private val _snackbarChannel = Channel<String>()
    val snackbarEvents = _snackbarChannel.receiveAsFlow()

    init {
        getAppList()
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _snackbarChannel.send("Клик по логотипу")
        }
    }

    fun getAppList() {
        viewModelScope.launch {
            _state.value = AppListState.Loading

            runCatching {
                val appList = getAppListUseCase()
                _state.value = AppListState.Content(
                    appList = appList.map { mapper.map(it) }
                )
            }.onFailure {
                _state.value = AppListState.Error
            }
        }
    }
}