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
//declaration du listOfUser de type ArrayList de User
    var listOfUser :  ArrayList<User> = ArrayList(1)
	//declaration du recyclerViewer
    lateinit var recyclerViewer: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
		//trouver notre recyclerViewer avec findViewById et le metre dans l'attribut recyclerViewer
        recyclerViewer= findViewById(R.id.recyclerViewer)

//Création de l'instance objet service du class UserService
        val service = getInstance().create(UserService::class.java)
//construit une nouvelle portée à l'endroit
        MainScope().launch {
		// declaration de l'attribut response qui contient les users 
            var  response = service.getUsers()
			
            listOfUser = response as ArrayList<User>
			//affichage de listOfUser
            showInView(listOfUser)

        }





    }
	//fonction pour afficher la recyclerview dans notre layout
    private fun showInView(arrayWithData: java.util.ArrayList<User>) {
	//declaration du l'attribut adapter du class UserAdapter pour afficher la ListOfUser dans la layout
        val adapter=UserAdapter(this,listOfUser)
		//afficher la recyclerViewer dans notre layout
        recyclerViewer.layoutManager = LinearLayoutManager(this)
		//on fait l'appel au recyclerViewer puis au notre adapter pour afficher notre data lise des users
        recyclerViewer.adapter=adapter
    }
}
