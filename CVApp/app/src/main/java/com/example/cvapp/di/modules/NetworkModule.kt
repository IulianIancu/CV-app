package com.example.cvapp.di.modules

import com.challenge.mycvapp.BuildConfig
import com.example.cvapp.data.remote.MyCvService
import com.example.cvapp.data.remote.REQUEST_TIMEOUT
import com.example.cvapp.di.scopes.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @AppScope
    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val okHttpLoggingInterceptor = HttpLoggingInterceptor()
        if(BuildConfig.DEBUG){
            okHttpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        return okHttpLoggingInterceptor
    }


    @AppScope
    @Provides
    internal fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @AppScope
    @Provides
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.HOST_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @AppScope
    @Provides
    internal fun provideMyCvService(retrofit: Retrofit): MyCvService {
        return retrofit.create<MyCvService>(MyCvService::class.java)
    }
}