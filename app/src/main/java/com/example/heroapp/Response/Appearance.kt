package com.example.heroapp.Response

data class Appearance(
    val eyecolor: String,
    val gender: String,
    val haircolor: String,
    val height: List<String>,
    val race: String,
    val weight: List<String>
)