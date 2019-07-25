package com.example.cvapp.ui.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

open class BaseViewModel @Inject constructor(private val compositeDisposable: CompositeDisposable) : ViewModel() {

    protected fun addDisposable(disposable: Disposable) {
        if (!compositeDisposable.isDisposed) compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) compositeDisposable.dispose()
    }
}