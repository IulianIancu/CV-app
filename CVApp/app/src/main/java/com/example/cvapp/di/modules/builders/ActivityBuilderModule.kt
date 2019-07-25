package com.example.cvapp.di.modules.builders

import com.example.cvapp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    // by doing this we no longer need to define scopes for Activities. I.e. ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMyCvActivity() : MainActivity

}