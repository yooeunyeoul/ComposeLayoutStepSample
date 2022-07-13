package com.dongeul.composelayoutstepsample.shoppingmall.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResult(
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
) {
}