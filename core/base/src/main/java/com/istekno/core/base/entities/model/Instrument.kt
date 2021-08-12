package com.istekno.core.base.entities.model

data class Instrument(
    val index: String,
    val name: String,
    val price: Double,
    val change_day: Double,
    val change_day_percent: Double
)
