package com.dongeul.composelayoutstepsample.shoppingmall.network

import io.ktor.client.*
import javax.inject.Inject

class ServiceOneImpl @Inject constructor(private val httpClient: HttpClient) : ApiServiceOne {
    override suspend fun getOneInfo() {

    }
}