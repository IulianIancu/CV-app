package com.example.cvapp.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.cvapp.factories.ViewModelFactory
import com.example.cvapp.factories.ViewModelKey
import com.example.cvapp.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMyCvViewModel(stackExchangeViewModel: MainViewModel) : ViewModel

    // Bind all other viewModels here
}