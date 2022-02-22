package com.muhsanapps.viewpagerwithindicators

import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private val images: List<Int>):
    RecyclerView.Adapter<ViewPagerAdapter.viewPagerViewHolder>() {

    inner class viewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById<ImageView>(R.id.ivImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return viewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: viewPagerViewHolder, position: Int) {
        val curImage = images[position]
        holder.imageView.setImageResource(curImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}