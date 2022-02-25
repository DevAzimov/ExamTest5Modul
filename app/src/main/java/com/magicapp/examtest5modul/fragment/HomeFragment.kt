package com.magicapp.examtest5modul.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magicapp.examtest5modul.R
import com.magicapp.examtest5modul.adapter.HomeAdapter
import com.magicapp.examtest5modul.model.Categories
import com.magicapp.examtest5modul.model.Restaurant

class HomeFragment: Fragment(){

    lateinit var recyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        initViews(view)
        return view
    }
    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(activity, 1))

        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(restaurant:  ArrayList<Restaurant>) {
        val adapter = HomeAdapter(this, restaurant)
        recyclerView!!.adapter = adapter
    }

    private fun getAllChats(): ArrayList<Restaurant> {
        val categories:ArrayList<Categories> = ArrayList<Categories>()

        for (i in 1..15) {
            if (i == 1 ) {
                categories.add(Categories(R.drawable.person_1))
            }else if (i == 2 || i == 7|| i == 11) {
                categories.add(Categories(R.drawable.person_1))
            } else if (i == 4 || i == 8|| i == 13) {
                categories.add(Categories(R.drawable.person_1))
            } else {
                categories.add(Categories(R.drawable.person_1))
            }
        }
        val chats:ArrayList<Restaurant> = ArrayList<Restaurant>()
        restaurant.add(Categories(categories))
        for (i in 1..15) {
            if (i == 1|| i == 6 || i == 10 ) {
                restaurant.ategories.add(Categories(R.drawable.person_1))
            }else if (i == 2 || i == 7|| i == 11) {
                restaurant.ategories.add(Categories(R.drawable.person_1))

            } else if (i == 4 || i == 8|| i == 13) {
                restaurant.ategories.add(Categories(R.drawable.person_1))

            } else {
                restaurant.ategories.add(Categories(R.drawable.person_1))

            }
        }
        return chats
}