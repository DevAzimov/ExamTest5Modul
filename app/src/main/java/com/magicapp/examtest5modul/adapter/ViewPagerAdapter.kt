package com.magicapp.examtest5modul.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.magicapp.examtest5modul.R
import com.magicapp.examtest5modul.model.IntroModel


class ViewPagerAdapter(var context: Context, var items: ArrayList<IntroModel>) :
    RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHoder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHoder {
        return Pager2ViewHoder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager2, parent, false)
        )
    }


    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHoder, position: Int) {
        var feed = items[position]

        if (holder is Pager2ViewHoder) {
            var image = holder.image
            var title = holder.title
            var description = holder.description

            image.setImageResource(feed.image)
            title.text = feed.title
            description.text = feed.description
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Pager2ViewHoder(v: View) : RecyclerView.ViewHolder(v) {
        var image: ImageView
        var title: TextView
        var description: TextView

        init {
            image = v.findViewById(R.id.iv_view_pager_image)
            title = v.findViewById(R.id.tv_title)
            description = v.findViewById(R.id.tv_description)
        }
    }


}