package com.arsars.realestateapp.ui.screens.property.list

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arsars.realestateapp.R
import com.arsars.realestateapp.domain.Property
import com.arsars.realestateapp.domain.usecases.properties.GetPropertiesUseCase
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
    private val getPropertiesUseCase: GetPropertiesUseCase,
    private val resources: Resources
) : ViewModel() {

    private val _screenState = MutableStateFlow(PropertiesScreenState())
    val screenState: StateFlow<PropertiesScreenState> = _screenState.asStateFlow()

    private val _screenEvent = MutableSharedFlow<PropertyScreenEvent>()
    val screenEvent = _screenEvent.asSharedFlow()

    init {
        loadItems()
    }

    fun openPropertyDetails(property: Property) {
        viewModelScope.launch {
            _screenEvent.emit(PropertyScreenEvent.OpenPropertyDetails(property.id))
        }
    }

    fun loadItems() {
        viewModelScope.launch {
            _screenState.update { it.copy(isLoading = true) }
            try {
                val result = getPropertiesUseCase(GetPropertiesUseCase.Input)
                _screenState.update {
                    it.copy(
                        isLoading = false,
                        properties = result.properties
                    )
                }
            } catch (ex: Throwable) {
                _screenState.update {
                    it.copy(
                        isLoading = false,
                        properties = emptyList()
                    )
                }
                _screenEvent.emit(PropertyScreenEvent.ShowError(resources.getString(R.string.cannot_load)))
            }
        }
    }
}