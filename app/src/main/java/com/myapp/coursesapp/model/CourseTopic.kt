package com.myapp.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicName: Int,
    val associatedCourse: Int,
    @DrawableRes val imageResourceID: Int,
)
