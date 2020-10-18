package com.nyan.ktmvvmhilt.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.nyan.ktmvvmhilt.model.Manga
import com.nyan.ktmvvmhilt.repository.MainRepository
import com.nyan.ktmvvmhilt.utils.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.Instant

class MainViewModel
@ViewModelInject
constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Manga>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Manga>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(mainStateEvent) {

                is MainStateEvent.GetMangaEvents -> {
                    mainRepository.getManga()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }

                is MainStateEvent.None -> {
                    //When nothing happen.
                }

            }
        }
    }

}

sealed class MainStateEvent {

    object GetMangaEvents: MainStateEvent()

    object None: MainStateEvent()

}