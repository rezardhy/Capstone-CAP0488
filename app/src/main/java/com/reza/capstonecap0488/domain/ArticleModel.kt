package com.reza.capstonecap0488.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleModel(
        var title: String = "",
        var img:Int = 0,
        var content :String = ""
):Parcelable