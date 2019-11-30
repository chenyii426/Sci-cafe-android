package com.cs4540.sci_cafe.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id:Int,

    @SerializedName("enabled")
    val enabled:Int,

    @SerializedName("token")
    val token:String,

    @SerializedName("username")
    val username:String,

    @SerializedName("password")
    val password:String,

    @SerializedName("firstName")
    val firstName: String,

    @SerializedName("lastName")
    val lastName: String,

    @SerializedName("roles")
    val roles: Set<Role>,

    @SerializedName("position")
    val position:String,

    @SerializedName("unit")
    val unit:String,

    @SerializedName("programs")
    val programs:Set<Program>,

    @SerializedName("title")
    val title:String,

    @SerializedName("email")
    val email:String

//    @SerializedName("events")
//    val events:Set<Event>

)