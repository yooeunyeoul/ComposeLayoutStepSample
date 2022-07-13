package com.dongeul.composelayoutstepsample.shoppingmall.network

import com.dongeul.composelayoutstepsample.shoppingmall.model.ApiResult
import com.dongeul.composelayoutstepsample.shoppingmall.model.UserInfo

interface ApiServiceOne {
    suspend fun getOneInfo(userInfo: UserInfo): List<ApiResult>
}