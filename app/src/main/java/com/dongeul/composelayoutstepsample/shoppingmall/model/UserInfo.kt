package com.dongeul.composelayoutstepsample.shoppingmall.model

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    val id: String,
    val pw: String,
    val nickname: String,
    val stateMessage: String
)