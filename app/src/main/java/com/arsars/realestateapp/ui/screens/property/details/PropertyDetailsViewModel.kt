package com.arsars.realestateapp.ui.screens.property.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arsars.realestateapp.domain.usecases.properties.GetPropertyUseCase
import com.arsars.realestateapp.ui.navigation.DestinationArgs.PROPERTY_ID_ARG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyDetailsViewModel
@Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPropertyUseCase: GetPropertyUseCase
) : ViewModel() {

    private val id: Long? = savedStateHandle[PROPERTY_ID_ARG]

    private val _screenState = MutableStateFlow(PropertyScreenState())
    val screenState: StateFlow<PropertyScreenState> = _screenState.asStateFlow()

    private val _screenEvent = MutableSharedFlow<PropertyScreenEvent>()
    val screenEvent = _screenEvent.asSharedFlow()

    init {
        loadProperty()
    }

    fun loadProperty() {
        viewModelScope.launch {
            if (id != null) {
                _screenState.update { it.copy(isLoading = true) }
                val result = getPropertyUseCase.execute(GetPropertyUseCase.Input(id))
                _screenState.update {
                    it.copy(
                        isLoading = false,
                        property = result.property
                    )
                }
            } else {
                _screenEvent.emit(PropertyScreenEvent.NavigateUp)
            }
        }
    }

}