package com.arusoft.joseluisrf.taiwanexampleapp.di.component

import android.app.Application
import com.arusoft.joseluisrf.taiwanexampleapp.CustomApplication
import com.arusoft.joseluisrf.taiwanexampleapp.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
        modules = arrayOf(
                AndroidInjectionModule::class,
                ApplicationModule::class,
                MainActivityModule::class,
                NetworkModule::class,
                StorageModule::class,
                RepositoryModule::class)
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

//        @BindsInstance
//        fun networkModule(networkModule: NetworkModule) : Builder
//
//        @BindsInstance
//        fun storageModule(storageModule: StorageModule) : Builder
//
//        @BindsInstance
//        fun repositoryModule(repositoryModule: RepositoryModule) : Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: CustomApplication)
}