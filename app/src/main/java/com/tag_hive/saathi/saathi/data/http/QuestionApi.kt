package com.tag_hive.saathi.saathi.data.http

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


/// TODO 추후 api로 변경시 interface 해서 retrofit형식으로 변경
@Singleton
class QuestionApi @Inject constructor() {
    fun getQuestionRecommendations(
        chapterId: String,
        studentId: String,
        questionIds: List<String> = listOf()
    ): Flow<List<String>> {

        val data = hashMapOf(
            "chapterId" to chapterId,
            "studentId" to studentId,
            "questionIds" to questionIds
        )
//        return flow {
//            FirebaseFunctions.getInstance().getHttpsCallable("getQuestionRecommendations")
//                .call(data)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        task.result?.let { result ->
//                            @Suppress("UNCHECKED_CAST")
//                            val list = result.data as ArrayList<String>
//                            if (list.isNotEmpty()) {
//                                emit(list.first())
//                            }
//                            error("error")
//                        }
//                    } else {
//                        error("error")
//                    }
//                }
//        }.catch {
//
//        }
        return flow {
            emit(listOf<String>())
        }
    }
}