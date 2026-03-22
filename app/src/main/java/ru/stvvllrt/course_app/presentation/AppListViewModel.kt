package ru.stvvllrt.course_app.presentation

import androidx.activity.result.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import ru.stvvllrt.course_app.Data
import kotlinx.coroutines.launch

class AppListViewModel : ViewModel() {
    private val _appList = MutableStateFlow<List<Data.Apps>>(emptyList())
    val appList: StateFlow<List<Data.Apps>> = _appList.asStateFlow()
    private val _snackbarChannel = Channel<String>()
    val snackbarEvents = _snackbarChannel.receiveAsFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        _appList.value = Data.appList
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _snackbarChannel.send("Клик по логотипу")
        }
    }
    fun getAppByName(name: String?): Data.Apps? {
        return _appList.value.find { it.name == name }
    }
}