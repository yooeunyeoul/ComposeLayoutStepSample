package com.dongeul.composelayoutstepsample.airplane.repository

import com.dongeul.composelayoutstepsample.airplane.DestinationsLocalDataSource
import com.dongeul.composelayoutstepsample.airplane.model.ExploreModel
import com.dongeul.composelayoutstepsample.shoppingmall.model.UserInfo
import com.dongeul.composelayoutstepsample.shoppingmall.network.ApiServiceOne
import io.ktor.client.*
import javax.inject.Inject

class DestinationsRepository @Inject constructor(
    private val destinationsLocalDataSource: DestinationsLocalDataSource,
    private val apiServiceOne: ApiServiceOne
) {
    val destinations: List<ExploreModel> = destinationsLocalDataSource.craneDestinations
    val hotels: List<ExploreModel> = destinationsLocalDataSource.craneHotels
    val restaurants: List<ExploreModel> = destinationsLocalDataSource.craneRestaurants


    fun getDestination(cityName: String): ExploreModel? {
        return destinationsLocalDataSource.craneDestinations.firstOrNull {
            it.city.name == cityName
        }
    }

    suspend fun registerLogin() =
        apiServiceOne.getOneInfo(
            userInfo = UserInfo(
                id = "dddd",
                pw = "asdfasdf",
                nickname = "nickName",
                stateMessage = "asdfdsf"
            )
        )


}