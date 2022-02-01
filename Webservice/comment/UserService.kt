package com.horizon.webservice

import retrofit2.Response
import retrofit2.http.GET

interface UserService {
//interface permet de récupérer les users de la liste ArrayList<User>
    @GET("users")
    suspend fun getUsers() : ArrayList<User>
}

