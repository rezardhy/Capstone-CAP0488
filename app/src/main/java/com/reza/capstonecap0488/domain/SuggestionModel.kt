package com.reza.capstonecap0488.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuggestionModel (
        var nama:String = "",
        var penyebab:String = "",
        var solusi:String = ""
        ):Parcelable