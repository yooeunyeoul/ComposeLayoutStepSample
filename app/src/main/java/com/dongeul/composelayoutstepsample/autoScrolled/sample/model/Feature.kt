package com.dongeul.composelayoutstepsample.autoScrolled.sample.model

import androidx.annotation.DrawableRes
//https://www.droidcon.com/2021/06/04/infinite-auto-scrolling-lists-with-recyclerview-lazylists-in-compose/
data class Feature(
    @DrawableRes val iconResource: Int,
    val contentDescription: String,
)