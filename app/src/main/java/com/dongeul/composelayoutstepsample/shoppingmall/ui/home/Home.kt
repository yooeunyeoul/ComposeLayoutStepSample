package com.dongeul.composelayoutstepsample.shoppingmall.ui.home

import androidx.annotation.StringRes
import com.dongeul.composelayoutstepsample.R

enum class HomeSections(
    @StringRes val title: Int,
    val route: String
){
    MAIN(R.string.home_main,"home/main"),
    SEARCH(R.string.home_search,"home/search"),
    CART(R.string.home_cart,"home/cart"),
    PROFILE(R.string.home_profile,"home/profile"),
}