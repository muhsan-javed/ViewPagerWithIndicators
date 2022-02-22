package com.muhsanapps.viewpagerwithindicators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var iv1: ImageView
    private lateinit var iv2: ImageView
    private lateinit var iv3: ImageView

    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.view_pager2)
        iv1 = findViewById(R.id.iv1)
        iv2 = findViewById(R.id.iv2)
        iv3 = findViewById(R.id.iv3)

        val images = listOf(R.drawable.rain_bd, R.drawable.snow, R.drawable.rain_bd)

        val adapter = ViewPagerAdapter(images)

        viewPager2.adapter = adapter

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                changeColor()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeColor()
            }
        })


    }

    fun changeColor() {
        when (viewPager2.currentItem) {
            0 -> {
                iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.active))
                iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.gray))
                iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.gray))
            }
            1 -> {
                iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.gray))
                iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.active))
                iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.gray))
            }
            2 -> {
                iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.gray))
                iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.gray))
                iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.active))
            }

        }
    }
}