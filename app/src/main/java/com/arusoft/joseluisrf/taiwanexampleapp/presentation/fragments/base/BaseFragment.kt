package com.arusoft.joseluisrf.taiwanexampleapp.presentation.fragments.base

import android.support.v4.app.Fragment
import com.arusoft.joseluisrf.taiwanexampleapp.CustomApplication
import com.arusoft.joseluisrf.taiwanexampleapp.di.component.ApplicationComponent


abstract class BaseFragment : Fragment() {


    fun getApplicationComponent() :
            ApplicationComponent =  (context?.applicationContext as CustomApplication).applicationComponent

}