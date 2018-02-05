package com.arusoft.joseluisrf.taiwanexampleapp.di.component

import android.content.Context
import com.arusoft.joseluisrf.taiwanexampleapp.data.api.interceptor.ApiInterceptor
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.AppDataBase
import com.arusoft.joseluisrf.taiwanexampleapp.di.module.ApplicationModule
import com.arusoft.joseluisrf.taiwanexampleapp.di.module.ViewModelModule
import com.arusoft.joseluisrf.taiwanexampleapp.domain.executor.PostExecutionThread
import com.arusoft.joseluisrf.taiwanexampleapp.domain.executor.ThreadExecutor
import com.arusoft.joseluisrf.taiwanexampleapp.util.DeviceUtils
import com.arusoft.joseluisrf.taiwanexampleapp.util.PermissionsManager
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ViewModelModule::class))
interface ApplicationComponent {

    fun context(): Context

    fun threadExecutor() : ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    fun deviceUtils(): DeviceUtils

    fun apiInterceptor() : ApiInterceptor

    fun appDataBase(): AppDataBase

    fun permissionsManager(): PermissionsManager

}