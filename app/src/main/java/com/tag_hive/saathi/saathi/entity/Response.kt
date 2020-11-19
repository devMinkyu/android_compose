package com.tag_hive.saathi.saathi.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagHiveSaathiApiAuth(
    val firebaseCustomJwtToken: String,
    val role: String,
    val awsToken: String,
    val awsId: String,
    val docId: String
)

@JsonClass(generateAdapter = true)
data class TagHiveApiOperationSuccess(val operationIds: List<String>)

@JsonClass(generateAdapter = true)
data class UpdateUserBody(val token: String, val newPassword: String, val oldPassword: String)

@JsonClass(generateAdapter = true)
data class UpdateFcmTokenUserBody(val token: String, val fcmToken: String, val fcmId: String)

@JsonClass(generateAdapter = true)
data class SignUpBody(val userId: String, val password: String, val inviteCode: String)

@JsonClass(generateAdapter = true)
data class SignInBody(val userId: String, val password: String)

@JsonClass(generateAdapter = true)
data class GoogleSignInBody(val idToken: String)

@JsonClass(generateAdapter = true)
data class GoogleOAuthSignUp(val idToken: String, val grade: Int?, val inviteCode: String?, val gender: Int?)