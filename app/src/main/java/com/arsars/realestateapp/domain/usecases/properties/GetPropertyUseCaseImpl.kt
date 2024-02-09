package com.arsars.realestateapp.domain.usecases.properties

import com.arsars.realestateapp.di.DispatcherIo
import com.arsars.realestateapp.domain.PropertyRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetPropertyUseCaseImpl @Inject constructor(
    @DispatcherIo
    dispatcher: CoroutineDispatcher,
    private val propertyRepository: PropertyRepository
) : GetPropertyUseCase(dispatcher) {
    override suspend fun execute(params: Input): Output {
        val property = propertyRepository.getProperty(params.id)
        return Output(property)
    }

}