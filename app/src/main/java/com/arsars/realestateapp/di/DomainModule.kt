package com.arsars.realestateapp.di

import com.arsars.realestateapp.data.PropertiesRemoteDataSource
import com.arsars.realestateapp.data.PropertyRepositoryImpl
import com.arsars.realestateapp.data.mappers.PropertyRemoteDataToPropertyMapper
import com.arsars.realestateapp.data.remote.PropertiesRemoteDataSourceImpl
import com.arsars.realestateapp.domain.PropertyRepository
import com.arsars.realestateapp.domain.usecases.GetPropertiesUseCase
import com.arsars.realestateapp.domain.usecases.GetPropertiesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainModule {

    @Binds
    fun bindGetPropertiesUseCase(getPropertiesUseCase: GetPropertiesUseCaseImpl): GetPropertiesUseCase

    @Binds
    fun bindPropertiesRepository(propertiesRepository: PropertyRepositoryImpl): PropertyRepository

    @Binds
    fun bindPropertiesRemoteDataSource(propertiesRemoteDataSource: PropertiesRemoteDataSourceImpl): PropertiesRemoteDataSource

    companion object {
        @Provides
        fun getPropertyRemoteDataToPropertyMapper() = PropertyRemoteDataToPropertyMapper()

    }
}