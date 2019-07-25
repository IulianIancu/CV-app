package com.example.cvapp.di.components

import com.example.cvapp.MainApplication
import com.example.cvapp.di.modules.CvAppModule
import com.example.cvapp.di.modules.NetworkModule
import com.example.cvapp.di.modules.ViewModelModule
import com.example.cvapp.di.modules.builders.ActivityBuilderModule
import com.example.cvapp.di.scopes.AppScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        CvAppModule::class
    ]
)
interface CvAppComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainApplication>()
}