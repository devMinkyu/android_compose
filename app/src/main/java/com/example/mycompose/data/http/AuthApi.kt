package com.example.mycompose.data.http

import androidx.annotation.Keep
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url

@Keep
interface AuthApi {
    @GET
    fun get(
        @Url url: String,
        @QueryMap options: Map<String, String>,
    ): Flow<Response<Any>>

//    @POST
//    fun post(
//        @Url url: String,
//        @PartMap params: Map<String, @JvmSuppressWildcards RequestBody>,
//    ): Completable
//
//    @PUT
//    fun put(
//        @Url url: String,
//        @PartMap params: Map<String, @JvmSuppressWildcards RequestBody>,
//    ): Completable
//
//    @DELETE
//    fun delete(@Url url: String): Completable
}