package com.tag_hive.saathi.saathi.domain.repository

import com.tag_hive.saathi.saathi.entity.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    fun getQuestionRecommendations(
        chapterId: String,
        studentId: String,
        questionIds: List<String> = listOf()
    ): Flow<String>

    fun getQuestion(
        questionId: String
    ): Flow<Question>
}