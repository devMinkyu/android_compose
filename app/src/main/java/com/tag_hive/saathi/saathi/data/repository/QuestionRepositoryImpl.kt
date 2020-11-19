package com.tag_hive.saathi.saathi.data.repository

import com.tag_hive.saathi.saathi.data.http.QuestionApi
import com.tag_hive.saathi.saathi.domain.repository.QuestionRepository
import com.tag_hive.saathi.saathi.entity.Question
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuestionRepositoryImpl @Inject constructor() : QuestionRepository {
    @Inject
    lateinit var questionApi: QuestionApi

    override fun getQuestionRecommendations(
        chapterId: String,
        studentId: String,
        questionIds: List<String>
    ): Flow<String> {
        // questionId 를 저장시켜야하는 곳(5개 넘어옴)
        // 반환값은 첫번째 questionId
        return questionApi.getQuestionRecommendations(
            chapterId, studentId,
            questionIds = questionIds
        ).map {
            it.first()
        }.catch {
            // 에러 처리
        }
    }

    override fun getQuestion(questionId: String): Flow<Question> {
        return flow {
            emit(Question())
        }
    }
}