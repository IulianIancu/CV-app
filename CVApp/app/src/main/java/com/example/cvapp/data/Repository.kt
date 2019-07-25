package com.example.cvapp.data

import com.example.cvapp.data.model.CV
import com.example.cvapp.data.remote.RemoteDataSource
import com.example.cvapp.di.scopes.AppScope
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@AppScope
class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    fun getMyCV() : Single<CV> {
        return remoteDataSource.getMyCV()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}