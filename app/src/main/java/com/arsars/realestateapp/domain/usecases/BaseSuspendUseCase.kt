package com.arsars.realestateapp.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseSuspendUseCase<in I : BaseSuspendUseCase.Input, out O : BaseSuspendUseCase.Output>(
    private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(params: I): O {
        return withContext(dispatcher) {
            execute(params)
        }
    }

    abstract suspend fun execute(params: I): O

    interface Input
    interface Output
}