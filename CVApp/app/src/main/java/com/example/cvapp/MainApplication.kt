package com.example.cvapp

import com.example.cvapp.di.components.DaggerCvAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasActivityInjector

class MainApplication : DaggerApplication(), HasActivityInjector {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerCvAppComponent.builder().create(this)

    }

}
