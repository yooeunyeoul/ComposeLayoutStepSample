package com.dongeul.composelayoutstepsample.shoppingmall.network

import io.ktor.client.*
import javax.inject.Inject


class ServiceTwoImpl @Inject constructor(private val httpClient : HttpClient) : ApiServiceTwo {
    override suspend fun getTwoInfo() {

    }
}