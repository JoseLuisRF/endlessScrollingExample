package com.arusoft.joseluisrf.taiwanexampleapp.di.module

import android.content.Context
import com.arusoft.joseluisrf.taiwanexampleapp.CustomApplication
import com.arusoft.joseluisrf.taiwanexampleapp.UIThread
import com.arusoft.joseluisrf.taiwanexampleapp.data.api.interceptor.ApiInterceptor
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.AppDataBase
import com.arusoft.joseluisrf.taiwanexampleapp.data.executor.JobExecutor
import com.arusoft.joseluisrf.taiwanexampleapp.domain.executor.PostExecutionThread
import com.arusoft.joseluisrf.taiwanexampleapp.domain.executor.ThreadExecutor
import com.arusoft.joseluisrf.taiwanexampleapp.util.DeviceUtils
import com.arusoft.joseluisrf.taiwanexampleapp.util.PermissionsManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = arrayOf( ViewModelModule::class))
class ApplicationModule constructor(private val context: CustomApplication) {

//    @Provides
//    @Singleton
//    fun providesContext(): Context = this.context

    @Provides
    @Singleton
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Provides
    @Singleton
    internal fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread = uiThread

    @Provides
    @Singleton
    internal fun providesDeviceUtils(context: Context): DeviceUtils = DeviceUtils(context)

    @Provides
    @Singleton
    internal fun providesPermissionsManager(context: Context): PermissionsManager = PermissionsManager(context)

    @Singleton
    @Provides
    internal fun providesAppDatabase(context: Context): AppDataBase = AppDataBase.createDatabase(context)

    @Provides
    @Singleton
    fun providesApiInterceptor(): ApiInterceptor = ApiInterceptor()
}