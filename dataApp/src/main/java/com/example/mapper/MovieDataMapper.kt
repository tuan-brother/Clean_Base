package com.example.mapper

import com.example.domainapp.entities.MovieEntity
import com.example.entities.MovieDbData


/**
 * Created by Ali Asadi on 13/05/2020
 **/

fun MovieEntity.toDbData() = MovieDbData(
    id = id,
    image = image,
    description = description,
    title = title,
    category = category,
    backgroundUrl = backgroundUrl
)
