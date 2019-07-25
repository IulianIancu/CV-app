package com.example.cvapp.di.modules

import android.content.Context
import com.example.cvapp.MainApplication
import com.example.cvapp.di.scopes.AppScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class CvAppModule {

    @AppScope
    @Provides
    fun provideAppContext(mainApplication: MainApplication) : Context = mainApplication.applicationContext

    @AppScope
    @Provides
    fun provideCompositeDisposable() : CompositeDisposable = CompositeDisposable()

}