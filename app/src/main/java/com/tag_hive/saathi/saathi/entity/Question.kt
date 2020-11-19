package com.tag_hive.saathi.saathi.entity

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class Question(
    var id: String = "", var questionTxt: String = "", @field:JvmField var isDelete: Boolean = false,
    @Suppress("ArrayInDataClass") var choices: MutableList<String>? = null,
    var answer: Int = -1,
    var creatorUserId: String = "",
    var txtImg: String? = null, var schoolId: String = "", var date: Date? = null, var lastUpdate: Date? = null,
    @Suppress("ArrayInDataClass") var chapterIds: MutableList<String>? = null,
    var difficulty: Int = DifficultyType.MEDIUM.ordinal,
    var likes: Int = 0,
    var teacherOfMonth: Boolean = false,
    var userName: String = "",
    var userId: String = "",
    var myLikeQuestionDocId: String = "",
    @Suppress("ArrayInDataClass") var skills: MutableList<String>? = null,
    var comment: String? = null, var solved: Int = 0, var questionDescription: String? = null,
    @Suppress("ArrayInDataClass") var choicesDescription: MutableList<String>? = null,
    var totalQuestions: Int = 0, var rightQuestions: Int = 0,
    var minTime: Int? = null,
    var maxTime: Int? = null,
    var midTime: Int? = null,
    var explanationImg: String = "",
    var privateStudentId: String = "",
    var questionTxtM: String = "",
    var choicesM: MutableList<String>? = null,
    var questionDescriptionM: String = "",
    var choicesDescriptionM: MutableList<String>? = null,
    var updatedDifficulty: Double? = null,
    @JvmField var mType: Int = -1 // Katex, MathJax
)

enum class DifficultyType {
    EASY, MEDIUM, HARD
}

