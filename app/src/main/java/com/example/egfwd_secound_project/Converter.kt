package com.example.egfwd_secound_project

import com.example.egfwd_secound_project.ui.model.Asteroid

fun java.util.ArrayList<Asteroid>.asAsteroidEntities() : Array<Asteroid> {
        return map {
            Asteroid(
                id = it.id,
                codename = it.codename,
                closeApproachDate = it.closeApproachDate,
                absoluteMagnitude = it.absoluteMagnitude,
                estimatedDiameter = it.estimatedDiameter,
                relativeVelocity = it.relativeVelocity,
                distanceFromEarth = it.distanceFromEarth,
                isPotentiallyHazardous = it.isPotentiallyHazardous
            )
        }.toTypedArray()

    }
