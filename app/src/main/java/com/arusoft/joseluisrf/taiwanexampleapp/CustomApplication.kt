package com.arusoft.joseluisrf.taiwanexampleapp

import android.app.Application
import com.arusoft.joseluisrf.taiwanexampleapp.di.ComponentsFactory
import com.arusoft.joseluisrf.taiwanexampleapp.di.component.ApplicationComponent

class CustomApplication : Application() {

    public lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = ComponentsFactory.createApplicationComponent(this)
    }

}