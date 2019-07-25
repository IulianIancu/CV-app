package com.example.cvapp.ui.base

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.LayoutRes
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {


    private lateinit var viewModelProvider: ViewModelProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())

        viewModelProvider = ViewModelProviders.of(this)
    }



    @LayoutRes
    abstract fun layoutRes(): Int
}