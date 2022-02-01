package com.horizon.webservice

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    val context: Context,
	//Instance attribut listUser du type ArrayList<User> pour recevoir les données des users et extends notre recycler view du class adapter 
    private val listUser: ArrayList<User>) : RecyclerView.Adapter
<UserAdapter.ViewHolder>() {
//fonction faire la liaison entre les items avec la recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
			//retourne la liaison du context avec notre item
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }
	//fonction permet de maitre les données dans la listUser
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bindView(listUser[position])
    }
	//class viewHolder pour construit notre items dans la viewHolder
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun  bindView(data: User){
		//déclaration des objets login id et image avec leurs id findViewById
            itemView.findViewById<TextView>(R.id.title).text = data.login
            itemView.findViewById<TextView>(R.id.sub_title).text= data.id.toString()
            Picasso.get().load(data.avatar_url).fit().placeholder(R.mipmap.ic_launcher).into(itemView.findViewById<ImageView>(R.id.image))
        }
    }
//fonction permet de retourne size du notre listUser
    override fun getItemCount(): Int {
        return listUser.size
    }


}