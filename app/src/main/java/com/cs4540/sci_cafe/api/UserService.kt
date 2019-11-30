package com.cs4540.sci_cafe.api

import com.cs4540.sci_cafe.models.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {
    @GET("/approvedEvents")
    fun login(username:String,password:String) {

    }

}