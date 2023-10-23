package com.abn.mymoviesabt.model

data class MovieDBResult(
    val page: Int,
    val results: List<MovieDB>,
    val total_pages: Int,
    val total_results: Int
)