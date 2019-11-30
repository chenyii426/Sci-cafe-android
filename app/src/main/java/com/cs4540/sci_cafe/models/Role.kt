package com.cs4540.sci_cafe.models

import com.google.gson.annotations.SerializedName

data class Role(
    @SerializedName("id")
    val id:Int,

    @SerializedName("name")
    val name:String
)