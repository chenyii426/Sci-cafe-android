package com.cs4540.sci_cafe.models

import com.google.gson.annotations.SerializedName

data class Program(
    @SerializedName("id")
    val id:Int,

    @SerializedName("name")
    val name:String,

    @SerializedName("fullName")
    val fullName:String,

    @SerializedName("description")
    val description:String,

    @SerializedName("imageUrl")
    val imageUrl:String

)