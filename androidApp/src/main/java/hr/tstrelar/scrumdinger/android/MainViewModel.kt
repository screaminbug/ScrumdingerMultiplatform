package hr.tstrelar.scrumdinger.android

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hr.tstrelar.scrumdinger.ClosableFlow
import hr.tstrelar.scrumdinger.Greeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val greeter: ClosableFlow<String>
    private val _greetingList = MutableStateFlow<List<String>>(listOf())
    val greetingList get() = _greetingList.asStateFlow()


    init {
        Log.d(this::class.simpleName, "Initializing main view model")
        greeter = Greeting()
        viewModelScope.launch {
            greeter.getFlow().collect { phrase ->
                _greetingList.update { list -> list + phrase }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(this::class.simpleName, "Closing resources")
        greeter.closeResources()
    }
}