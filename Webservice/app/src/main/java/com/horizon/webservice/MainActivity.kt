package com.horizon.webservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.horizon.webservice.RetrofitHelper.getInstance
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var listOfUser :  ArrayList<User> = ArrayList(1)
    lateinit var recyclerViewer: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewer= findViewById(R.id.recyclerViewer)


        val service = getInstance().create(UserService::class.java)

        MainScope().launch {
            var  response = service.getUsers()
            listOfUser = response as ArrayList<User>
            showInView(listOfUser)

        }

    }
    private fun showInView(arrayWithData: java.util.ArrayList<User>) {
        val adapter=UserAdapter(this,listOfUser)
        recyclerViewer.layoutManager = LinearLayoutManager(this)
        recyclerViewer.adapter=adapter
    }
}
