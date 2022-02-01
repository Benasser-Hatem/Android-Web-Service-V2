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
    private val listUser: ArrayList<User>) : RecyclerView.Adapter
<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bindView(listUser[position])
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun  bindView(data: User){
            itemView.findViewById<TextView>(R.id.title).text = data.login
            itemView.findViewById<TextView>(R.id.sub_title).text= data.id.toString()
            Picasso.get().load(data.avatar_url).fit().placeholder(R.mipmap.ic_launcher).into(itemView.findViewById<ImageView>(R.id.image))
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }


}