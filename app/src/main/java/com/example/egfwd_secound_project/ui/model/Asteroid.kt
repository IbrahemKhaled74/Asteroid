package com.example.egfwd_secound_project.ui.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Asteroid constructor(
    @ColumnInfo
    @PrimaryKey
    val id: Long,
    @ColumnInfo
    val codename: String,

    @ColumnInfo
    val closeApproachDate: String,

    @ColumnInfo
    val absoluteMagnitude: Double,

    @ColumnInfo
    val estimatedDiameter: Double,

    @ColumnInfo
    val relativeVelocity: Double,

    @ColumnInfo
    val distanceFromEarth: Double,

    @ColumnInfo
    val isPotentiallyHazardous: Boolean
) : Parcelable
