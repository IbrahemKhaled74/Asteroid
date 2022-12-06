package com.example.egfwd_secound_project.di.api

import com.example.egfwd_secound_project.Constants
import com.example.egfwd_secound_project.ui.api.WebServices
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideScalarsConverter():ScalarsConverterFactory{
        return ScalarsConverterFactory.create()
    }

    @Provides
    fun provideHttpInterceptor():HttpLoggingInterceptor{
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }


    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun provideApi(ScalarsConverterFactory: ScalarsConverterFactory,client: OkHttpClient):Retrofit{
       return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
           .client(client)
           .addConverterFactory(ScalarsConverterFactory)
           .addConverterFactory(MoshiConverterFactory.create(moshi))
           .addCallAdapterFactory(CoroutineCallAdapterFactory())
           .build()
    }
    @Provides
    fun getApis(retrofit: Retrofit):WebServices{
        return retrofit.create(WebServices::class.java)
    }
}