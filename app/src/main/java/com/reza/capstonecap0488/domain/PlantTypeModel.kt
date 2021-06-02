package com.reza.capstonecap0488.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlantTypeModel(
        var name: String = "",
        var img:Int = 0,
): Parcelable