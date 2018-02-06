package com.arusoft.joseluisrf.taiwanexampleapp

import android.support.multidex.MultiDexApplication
import com.arusoft.joseluisrf.taiwanexampleapp.di.ComponentsFactory
import com.arusoft.joseluisrf.taiwanexampleapp.di.component.ApplicationComponent

class CustomApplication : MultiDexApplication() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = ComponentsFactory.createApplicationComponent(this)
    }

}