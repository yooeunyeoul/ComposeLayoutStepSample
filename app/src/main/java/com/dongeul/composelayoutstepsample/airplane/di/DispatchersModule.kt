package com.dongeul.composelayoutstepsample.airplane.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier


@Module
@InstallIn(SingletonComponent::class)
class DispatchersModule {

    @Provides
    @EunyeoulPatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @DongeulPatcher
    fun provideDongeulDispatcher():CoroutineDispatcher = Dispatchers.Default
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class EunyeoulPatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DongeulPatcher