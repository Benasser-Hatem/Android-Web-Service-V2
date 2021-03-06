package com.horizon.webservice

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("login")
    val login: String = "",

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("avatar_url")
    val avatar_url: String = "",
)