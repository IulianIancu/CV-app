package com.example.cvapp.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.cvapp.data.Repository
import com.example.cvapp.data.model.CV
import com.example.cvapp.ui.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: Repository,
    compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable) {

    private val myCvLiveData = MutableLiveData<CV>()
    private val loadingLiveData = MutableLiveData<Boolean>()
    private val errorLiveData = MutableLiveData<Boolean>()

    fun getMyCV() {

        addDisposable(repository.getMyCV()
            .doOnSubscribe { loadingLiveData.value = true }
            .subscribe({ cv -> myCvLiveData.value = cv
                loadingLiveData.value = false
                errorLiveData.value = false
            },
                {
                    it.printStackTrace()
                    errorLiveData.value = true
                    loadingLiveData.value = false
                })
        )
    }


    fun getMyCvLiveData(): LiveData<CV> = myCvLiveData
    fun getLoadingLiveData(): LiveData<Boolean> = loadingLiveData
    fun getErrorLiveData(): LiveData<Boolean> = errorLiveData

}