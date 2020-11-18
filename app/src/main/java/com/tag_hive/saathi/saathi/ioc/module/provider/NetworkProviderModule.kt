package com.tag_hive.saathi.saathi.ioc.module.provider

import com.tag_hive.saathi.saathi.data.http.AuthApi
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import me.sianaki.flowretrofitadapter.FlowCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Singleton

@Suppress("unused")
@Module
@InstallIn(ApplicationComponent::class)
class NetworkProviderModule{
    @Provides
    @Singleton
    internal fun provideRemoteAuth(
        retrofit: Retrofit
    ): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    internal fun provideRemoteDataSource(
        client: OkHttpClient,
        moshi: Moshi
    ): Retrofit {
        val moshiConverterFactory = MoshiConverterFactory.create(moshi)

        val remoteClient = client.newBuilder()
            .retryOnConnectionFailure(true)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        val baseUrl = ""

        return Retrofit.Builder()
            .client(remoteClient)
            .baseUrl(baseUrl)
            .addConverterFactory(moshiConverterFactory)
            .addCallAdapterFactory(FlowCallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    @Singleton
    internal fun provideMoshi(): Moshi {
        return Moshi.Builder().add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
            .add(KotlinJsonAdapterFactory()).build()
    }

}