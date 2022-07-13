package com.dongeul.composelayoutstepsample.shoppingmall.di

import com.dongeul.composelayoutstepsample.shoppingmall.network.ApiServiceOne
import com.dongeul.composelayoutstepsample.shoppingmall.network.ApiServiceTwo
import com.dongeul.composelayoutstepsample.shoppingmall.network.ServiceOneImpl
import com.dongeul.composelayoutstepsample.shoppingmall.network.ServiceTwoImpl
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {

    @Binds
    @Singleton
    abstract fun provideServiceOne(apiServiceOneImpl: ServiceOneImpl): ApiServiceOne

    @Binds
    @Singleton
    abstract fun provideServiceTwo(apiServiceTwoImpl: ServiceTwoImpl): ApiServiceTwo

}