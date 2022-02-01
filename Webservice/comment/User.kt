package com.horizon.webservice

import com.google.gson.annotations.SerializedName

data class User (
//lier la clé "login" avec notre variable login
    @SerializedName("login")
    val login: String = "",
//lier la clé "id" avec notre variable id de type int
    @SerializedName("id")
    val id: Int = 0,
//lier la clé "avatar_url" avec notre variable avatar_url de type string
    @SerializedName("avatar_url")
    val avatar_url: String = "",
)