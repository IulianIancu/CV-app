package com.example.cvapp.data.remote

import com.example.cvapp.data.model.CV
import com.example.cvapp.di.scopes.AppScope
import io.reactivex.Single
import javax.inject.Inject

@AppScope
class RemoteDataSource @Inject constructor(private val myCvService: MyCvService) {

    fun getMyCV() : Single<CV> {
        return myCvService.getMyCV()

    }
}