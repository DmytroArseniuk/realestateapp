package com.arsars.realestateapp.domain.usecases.properties

import com.arsars.realestateapp.domain.Property
import com.arsars.realestateapp.domain.usecases.BaseSuspendUseCase
import kotlinx.coroutines.CoroutineDispatcher

abstract class GetPropertiesUseCase(dispatcher: CoroutineDispatcher) :
    BaseSuspendUseCase<GetPropertiesUseCase.Input, GetPropertiesUseCase.Output>(dispatcher) {
    object Input : BaseSuspendUseCase.Input

    data class Output(val properties: List<Property>) : BaseSuspendUseCase.Output

}