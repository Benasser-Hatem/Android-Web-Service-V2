package com.horizon.webservice

import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getUsers() : ArrayList<User>
}

