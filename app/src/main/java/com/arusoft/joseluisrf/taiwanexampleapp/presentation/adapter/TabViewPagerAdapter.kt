package com.arusoft.joseluisrf.taiwanexampleapp.presentation.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.fragments.CityGuideFragment
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.fragments.EatFragment
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.fragments.ShopFragment


class TabViewPagerAdapter constructor(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val NUMBER_OF_TABS: Int = 3
    private val CITY_GUIDE_FRAGMENT: Int = 1
    private val SHOP_FRAGMENT: Int = 2
    private val EAT_FRAGMENT: Int = 3

    override fun getItem(position: Int): Fragment =
            when (position) {
                CITY_GUIDE_FRAGMENT -> CityGuideFragment()
                SHOP_FRAGMENT -> ShopFragment()
                EAT_FRAGMENT -> EatFragment()
                else -> CityGuideFragment()
            }


    override fun getCount(): Int = NUMBER_OF_TABS

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        CITY_GUIDE_FRAGMENT -> "City Guide"
        SHOP_FRAGMENT -> "Shop"
        EAT_FRAGMENT -> "Eat"
        else -> "City Guide"
    }

}