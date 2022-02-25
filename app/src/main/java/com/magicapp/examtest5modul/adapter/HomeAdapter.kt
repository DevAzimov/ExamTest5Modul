package com.magicapp.examtest5modul.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.magicapp.examtest5modul.R
import com.magicapp.examtest5modul.fragment.HomeFragment
import com.magicapp.examtest5modul.model.Categories
import com.magicapp.examtest5modul.model.Home
import com.magicapp.examtest5modul.model.Restaurant
import java.util.ArrayList

class HomeAdapter (var context: HomeFragment, var items: ArrayList<Home>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1


    override fun getItemViewType(position: Int): Int {

        val feed: Home = items[position]
        if (feed.categoris.size > 0)
            return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSAGE
    }

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        if (viewType == TYPE_ITEM_ROOM) {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)
            return RoomViewHolder(context, view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = items[position]
        if (holder is RoomViewHolder){
            var recyclerView = holder.recyclerView
            refreshAdapter(message, recyclerView)
        }
        if (holder is MessageViewHolder){
            val iv_profile = holder.iv_profile


            iv_profile.setImageResource(message.profile)




        }

    }

    private fun refreshAdapter(rooms: ArrayList<Categories>, recyclerView: RecyclerView) {
        val adapter = Categories(context, rooms)
        recyclerView!!.adapter = adapter

    }

    class RoomViewHolder(context: HomeAdapter,view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView:RecyclerView

        init {
            recyclerView= view.findViewById(R.id.recyclerView)
            val manager = LinearLayoutManager(context,(LinearLayoutManager.HORIZONTAL), false)
            recyclerView.setLayoutManager(manager)
        }

    }
    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)


    }


}