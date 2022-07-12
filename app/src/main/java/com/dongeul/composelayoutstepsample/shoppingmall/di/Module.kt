package com.dongeul.composelayoutstepsample.shoppingmall.di

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideKtorHttpClient(): HttpClient {
        return HttpClient(CIO) {
            defaultRequest {
                headers {
                    append("Accept", "application/json")
                    append("Content-type", "application/json")
//                    append(HttpHeaders.Authorization, "Client-ID id 값")
                }
                url {
                    protocol = URLProtocol.HTTP
                    host = "api.unsplash.com"
                }
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer(json =  kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true //모델에 없고, json 에 있는경우 해당 key 무시
                    prettyPrint = true
                    isLenient = true // "" 따옴표 잘못된건 무시하고 처리
                    encodeDefaults = true // null 인 값도 json 에 포함 시킨다.
                })
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.d(TAG, message)
                    }
                }

            }
            install(HttpTimeout) {
                requestTimeoutMillis = 10_000L
                connectTimeoutMillis = 10_000L
                socketTimeoutMillis = 10_000L
            }


        }
    }
}