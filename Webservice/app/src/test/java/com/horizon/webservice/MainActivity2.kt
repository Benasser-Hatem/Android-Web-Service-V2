package com.horizon.webservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Call API GetUsers from the Interface USerService
        val instance = RetrofitHelper.getInstance().create(UserService::class.java)
        GlobalScope.launch{
            val call = instance.getUsers()
            Log.i("nomClasse","reponse = "+call.body().toString())
        }
    }
}

}
