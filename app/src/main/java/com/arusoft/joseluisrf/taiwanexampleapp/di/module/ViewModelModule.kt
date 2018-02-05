package com.arusoft.joseluisrf.taiwanexampleapp.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.arusoft.joseluisrf.taiwanexampleapp.di.scope.ViewModelKey
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.view.CityGuideViewModel
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.view.CustomViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CityGuideViewModel::class)
    abstract fun bindUserViewModel(userViewModel: CityGuideViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: CustomViewModelFactory): ViewModelProvider.Factory
}