package com.arsars.realestateapp.domain.usecases.properties

import com.arsars.realestateapp.di.DispatcherIo
import com.arsars.realestateapp.domain.PropertyRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetPropertiesUseCaseImpl @Inject constructor(
    @DispatcherIo
    dispatcher: CoroutineDispatcher,
    private val propertyRepository: PropertyRepository
) : GetPropertiesUseCase(dispatcher) {
    override suspend fun execute(params: Input): Output {
        val properties = propertyRepository.getAllProperties()
        return Output(properties)
    }
}