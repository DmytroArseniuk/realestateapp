package com.arsars.realestateapp.ui.screens.property.list

import android.content.res.Resources
import com.arsars.realestateapp.PropertiesStub
import com.arsars.realestateapp.domain.usecases.properties.GetPropertiesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PropertyListViewModelTest {

    private val getPropertiesUseCase: GetPropertiesUseCase = mockk(relaxed = true)
    private val resources: Resources = mockk()

    @Test
    fun initialSetup_success() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))

        coEvery { getPropertiesUseCase((GetPropertiesUseCase.Input)) } returns GetPropertiesUseCase.Output(
            PropertiesStub.allProperties
        )

        val viewModel = PropertyListViewModel(getPropertiesUseCase, resources)

        val state = viewModel.screenState.drop(1).first()

        Assert.assertEquals(PropertiesScreenState(properties = PropertiesStub.allProperties), state)

    }

}