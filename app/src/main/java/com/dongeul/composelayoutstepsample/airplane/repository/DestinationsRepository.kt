package com.dongeul.composelayoutstepsample.airplane.repository

import com.dongeul.composelayoutstepsample.airplane.DestinationsLocalDataSource
import com.dongeul.composelayoutstepsample.airplane.model.ExploreModel
import io.ktor.client.*
import javax.inject.Inject

class DestinationsRepository @Inject constructor(
    private val destinationsLocalDataSource: DestinationsLocalDataSource,
    private val httpClient: HttpClient
) {
    val destinations: List<ExploreModel> = destinationsLocalDataSource.craneDestinations
    val hotels: List<ExploreModel> = destinationsLocalDataSource.craneHotels
    val restaurants: List<ExploreModel> = destinationsLocalDataSource.craneRestaurants


    fun getDestination(cityName: String):ExploreModel? {
        return destinationsLocalDataSource.craneDestinations.firstOrNull {
            it.city.name == cityName
        }
    }

    fun checkHttpClient() {
        httpClient
    }




}