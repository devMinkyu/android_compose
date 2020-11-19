package com.tag_hive.saathi.saathi.common

sealed class ServerConfig(
    val baseApiUrl: String,
    val firebaseStorage: String,
    val infoEmail: String,
    val fcmSenderId: String,
    val s3UploadBucket:String,
) {
    object DevServerConfig : ServerConfig(
        baseApiUrl = "https://us-central1-saathi-dev.cloudfunctions.net",
        firebaseStorage = "gs://saathi-dev.appspot.com",
        infoEmail = "info@tag-hive.com",
        fcmSenderId = "997490355446",
        s3UploadBucket = "develop.tag-hive.com"
    )

    object RealServerConfig : ServerConfig(
        baseApiUrl = "https://us-central1-saathi-release.cloudfunctions.net",
        firebaseStorage = "gs://saathi-release.appspot.com",
        infoEmail = "info@tag-hive.com",
        fcmSenderId = "273342260613",
        s3UploadBucket = "tag-hive.com"
    )
}