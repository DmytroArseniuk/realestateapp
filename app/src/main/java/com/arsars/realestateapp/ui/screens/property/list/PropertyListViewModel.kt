package com.arsars.realestateapp.ui.screens.property.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arsars.realestateapp.domain.usecases.GetPropertiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyListViewModel
@Inject constructor(
    private val getPropertiesUseCase: GetPropertiesUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            val result = getPropertiesUseCase.invoke(GetPropertiesUseCase.Input)
            Log.d("ARSARS", "result: $result")
        }
    }
}