package com.dongeul.composelayoutstepsample.shoppingmall.network

import com.dongeul.composelayoutstepsample.shoppingmall.di.Module
import com.dongeul.composelayoutstepsample.shoppingmall.model.ApiResult
import com.dongeul.composelayoutstepsample.shoppingmall.model.UserInfo
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class ServiceOneImpl @Inject constructor(private val httpClient: HttpClient) : ApiServiceOne {
    override suspend fun getOneInfo(userInfo:UserInfo)=
        httpClient.get<List<ApiResult>>("https://api.thecatapi.com/v1/images/search?limit=5"){
//            parameter("id","eunyeoul")
//            parameter("pw","1234")
//            parameter("nickname","")
//            parameter("statemessage","")
//            body = userInfo
        }

}