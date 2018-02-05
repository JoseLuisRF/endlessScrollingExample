package com.arusoft.joseluisrf.taiwanexampleapp.di

import com.arusoft.joseluisrf.taiwanexampleapp.CustomApplication
import com.arusoft.joseluisrf.taiwanexampleapp.di.component.ApplicationComponent
import com.arusoft.joseluisrf.taiwanexampleapp.di.component.DaggerApplicationComponent
import com.arusoft.joseluisrf.taiwanexampleapp.di.component.DaggerUserComponent
import com.arusoft.joseluisrf.taiwanexampleapp.di.component.UserComponent
import com.arusoft.joseluisrf.taiwanexampleapp.di.module.ApplicationModule

class ComponentsFactory {

    companion object {

        @JvmStatic
        fun createApplicationComponent(context: CustomApplication): ApplicationComponent {
            return DaggerApplicationComponent.builder()
                    .applicationModule(ApplicationModule(context))
                    .build()
        }


        @JvmStatic
        fun createUserComponent(applicationComponent: ApplicationComponent): UserComponent {
            return DaggerUserComponent.builder()
                    .applicationComponent(applicationComponent)
                    .build()
        }

    }

}