package com.example.core.network.injection

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.example.core.common.injection.qualifier.AuthOkHttpClient
import com.example.core.common.injection.qualifier.NoAuthOkHttpClient
import com.example.core.network.BuildConfig
import com.example.core.network.datasource.DefaultDrugsDataSource
import com.example.core.network.datasource.DrugsRemoteDataSource

import com.example.core.network.service.MockyApi

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
@Suppress("TooManyFunctions")
object NetworkModule {
    @[Provides Singleton]
    fun provideChuckerInterceptor(
        @ApplicationContext context: Context,
    ): ChuckerInterceptor {
        // Create the Collector
        val chuckerCollector = ChuckerCollector(
            context = context,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR,
        )

        // Create the Interceptor
        @Suppress("MagicNumber")
        return ChuckerInterceptor.Builder(context).apply {
            collector(chuckerCollector)
            maxContentLength(250_000L)
            //redactHeaders("Auth-Token", "Bearer")
            alwaysReadResponseBody(true)
            createShortcut(true)
        }.build()
    }

    @[Provides Singleton AuthOkHttpClient]
    fun provideAuthOkHttpClient(chuckerInterceptor: ChuckerInterceptor): OkHttpClient {
        val builder =
            OkHttpClient.Builder().addInterceptor(chuckerInterceptor)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }

        return builder.build()
    }

    @[Provides Singleton NoAuthOkHttpClient]
    fun provideNoAuthOkHttpClient(chuckerInterceptor: ChuckerInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder().addInterceptor(chuckerInterceptor)
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }
        return builder.build()
    }

    @[Provides Singleton]
    fun provideGson(): Gson = GsonBuilder().apply {
        setPrettyPrinting()
        setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
    }.create()

    @[Provides Singleton]
    fun provideRetrofit(
        @AuthOkHttpClient okHttpClient: OkHttpClient,
        gson: Gson,
    ): Retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    @[Provides Singleton]
    fun providesMockyApi(retrofit: Retrofit): MockyApi =
        retrofit.create(MockyApi::class.java)


    @[Provides Singleton]
    fun providesDrugsRemoteDataSource(mockyApi: MockyApi): DrugsRemoteDataSource =
        DefaultDrugsDataSource(mockyApi = mockyApi)

}




