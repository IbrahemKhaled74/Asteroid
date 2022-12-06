package com.example.egfwd_secound_project.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity
data class PictureOfDay(
    @Json(name = "media_type")
    @ColumnInfo
    val mediaType: String,
    @ColumnInfo
    val title: String,
     @PrimaryKey
    @ColumnInfo
    val url: String
)
