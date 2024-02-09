package com.arsars.realestateapp.domain.usecases.properties

import com.arsars.realestateapp.domain.Property
import com.arsars.realestateapp.domain.usecases.BaseSuspendUseCase
import kotlinx.coroutines.CoroutineDispatcher

abstract class GetPropertyUseCase(dispatcher: CoroutineDispatcher) :
    BaseSuspendUseCase<GetPropertyUseCase.Input, GetPropertyUseCase.Output>(dispatcher) {
    data class Input(
        val id: Long
    ) : BaseSuspendUseCase.Input

    data class Output(val property: Property) : BaseSuspendUseCase.Output

}