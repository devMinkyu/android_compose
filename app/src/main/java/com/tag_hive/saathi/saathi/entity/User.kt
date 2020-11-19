package com.tag_hive.saathi.saathi.entity

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class User(
    var id: String = "",
    var role: String = "",
    var schoolId: String = "",
    var userId: String? = null, var name: String = "", var enable: Boolean = true,
    var inviteCode: String = "", var inviteCodeGenTime: Date? = null,
    var played: Int = 0, var liked_by: Int = 0, var played_by: Int = 0, var created: Int = 0,
    var comment: Int = 0,
    var premiumDate: Date? = null,
    var googleUid: String = "",
    var usedReferral: Boolean = false,
    var giveFeedback: Boolean = false,
    var filters: Map<String, String>? = null,
    var currentGrade: Int = 0,
    var currentClassId: String = "",
    var fbUid: String = "",
    var proclaimedSchoolName: String = "",
    var gender: Int = GenderType.MALE.ordinal
)

enum class GenderType {
    MALE, FEMALE, MRS, NONE
}