package com.arusoft.joseluisrf.taiwanexampleapp.di.component

import com.arusoft.joseluisrf.taiwanexampleapp.di.module.NetworkModule
import com.arusoft.joseluisrf.taiwanexampleapp.di.module.RepositoryModule
import com.arusoft.joseluisrf.taiwanexampleapp.di.module.StorageModule
import com.arusoft.joseluisrf.taiwanexampleapp.di.scope.UserScope
import com.arusoft.joseluisrf.taiwanexampleapp.presentation.fragments.CityGuideFragment
import dagger.Component

@UserScope
@Component(
        dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(
                NetworkModule::class,
                StorageModule::class,
                RepositoryModule::class))
interface UserComponent {

    fun inject(fragment: CityGuideFragment)
}