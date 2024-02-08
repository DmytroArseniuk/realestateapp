package com.arsars.realestateapp.ui.screens.property.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arsars.realestateapp.domain.Property
import com.arsars.realestateapp.domain.usecases.GetPropertiesUseCase
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
class PropertyListViewModel
@Inject constructor(
    private val getPropertiesUseCase: GetPropertiesUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow(PropertiesScreenState())
    val screenState: StateFlow<PropertiesScreenState> = _screenState.asStateFlow()

    private val _screenEvent = MutableSharedFlow<PropertyScreenEvent>()
    val screenEvent = _screenEvent.asSharedFlow()

    init {
        viewModelScope.launch {
            _screenState.update { it.copy(isLoading = true) }
            val result = getPropertiesUseCase.invoke(GetPropertiesUseCase.Input)
            _screenState.update {
                it.copy(
                    isLoading = false,
                    properties = result.properties
                )
            }
        }
    }

    fun openPropertyDetails(property: Property) {
        viewModelScope.launch {
            _screenEvent.emit(PropertyScreenEvent.OpenPropertyDetails(property.id))
        }
    }
}