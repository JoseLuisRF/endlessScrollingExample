package com.arusoft.joseluisrf.taiwanexampleapp.di.module

import com.arusoft.joseluisrf.taiwanexampleapp.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildersModule::class))
    internal abstract fun contributeMainActivity(): MainActivity

}