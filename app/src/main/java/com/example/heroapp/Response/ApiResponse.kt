package com.example.heroapp.Response

data class ApiResponse(
    val response: String,
    val results: List<Result>,
    val resultsfor: String
)