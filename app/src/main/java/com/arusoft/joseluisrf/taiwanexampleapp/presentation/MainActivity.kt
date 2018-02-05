package com.arusoft.joseluisrf.taiwanexampleapp.presentation

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arusoft.joseluisrf.taiwanexampleapp.R
import com.arusoft.joseluisrf.taiwanexampleapp.databinding.ActivityMainBinding
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.adapter.TabViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        binding.pager.adapter = TabViewPagerAdapter(supportFragmentManager)
        binding.mainTabLayout.setupWithViewPager(binding.pager)
    }
}
