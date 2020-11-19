package com.tag_hive.saathi.saathi.domain.usecase

import com.tag_hive.saathi.saathi.domain.repository.QuestionRepository
import com.tag_hive.saathi.saathi.entity.Question
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import javax.inject.Inject

// 추천 퀴즈 useCase
// singleton 까지 필요없고, 추천 퀴즈를 부르는 viewModel 생명주기면 충분
@ActivityRetainedScoped
class RecommendQuiz @Inject constructor() {
    @Inject
    lateinit var questionRepository: QuestionRepository


    @FlowPreview
    fun getQuestionRecommendations(): Flow<Question> {
        return questionRepository.getQuestionRecommendations(
            chapterId = "",
            studentId = "",
            questionIds = listOf()
        ).flatMapConcat {
            questionRepository.getQuestion(it)
        }
    }
}