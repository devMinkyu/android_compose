package com.tag_hive.saathi.saathi.data.http

import androidx.annotation.Keep
import com.tag_hive.saathi.saathi.entity.*
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.*

@Keep
interface AuthApi {
    @POST("signUp")
    fun signUp(@Body body: SignUpBody): Flow<Response<TagHiveSaathiApiAuth>>

    @POST("updateUser")
    fun updateUser(@Body body: UpdateUserBody): Flow<Response<TagHiveApiOperationSuccess>>

    @POST("updateUserFcmToken")
    fun updateFcmToken(@Body body: UpdateFcmTokenUserBody): Flow<Response<TagHiveApiOperationSuccess>>

    @POST("signIn")
    fun signIn(@Body body: SignInBody
    ): Flow<Response<TagHiveSaathiApiAuth>>

    @POST("google_sign_in")
    fun googleSignIn(
        @Header("Accept-Version") version:String,
        @Body body: GoogleSignInBody
    ): Flow<Response<TagHiveSaathiApiAuth>>

    @POST("google_sign_up")
    fun googleSignUp(
        @Header("Accept-Version") version:String,
        @Body body: GoogleOAuthSignUp
    ): Flow<Response<TagHiveSaathiApiAuth>>
}