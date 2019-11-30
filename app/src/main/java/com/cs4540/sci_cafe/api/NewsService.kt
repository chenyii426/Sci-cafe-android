package com.cs4540.sci_cafe.api

import com.cs4540.sci_cafe.models.News
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.http.Path

interface NewsService {
    @GET("/topNews")
    fun getAllTopNews(): Observable<List<News>>

    @GET("/news")
    fun getAllNews(): Observable<List<News>>

    @GET("/news/{newsId}")
    fun getNewsById(@Path("newsId") newsId:Int): Observable<News>
}