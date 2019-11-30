package com.cs4540.sci_cafe.api

import com.cs4540.sci_cafe.models.Event
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface EventService {
    @GET("/approvedEvents")
    fun getAllApprovedEvents(): Observable<List<Event>>

    @GET("/events")
    fun getAllEvents(): Observable<List<Event>>

    @GET("/event/{eventId}")
    fun getEventById(@Path("eventId") eventId:Int): Observable<Event>
}