package com.example.cvapp.data.remote

import com.challenge.mycvapp.BuildConfig
import com.example.cvapp.data.model.CV
import io.reactivex.Single
import retrofit2.http.GET

interface MyCvService {

    @GET(BuildConfig.RESUME_PATH)
    fun getMyCV() : Single<CV>
}