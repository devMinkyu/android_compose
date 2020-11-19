@file:Suppress("unused")

package com.tag_hive.saathi.saathi.ioc.module.provider

import com.tag_hive.saathi.saathi.data.repository.AuthRepositoryImpl
import com.tag_hive.saathi.saathi.data.repository.QuestionRepositoryImpl
import com.tag_hive.saathi.saathi.domain.repository.AuthRepository
import com.tag_hive.saathi.saathi.domain.repository.QuestionRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppBinderModule {
    @Singleton
    @Binds
    abstract fun bindAuthRepo(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Singleton
    @Binds
    abstract fun bindQuestionRepo(
        questionRepositoryImpl: QuestionRepositoryImpl
    ): QuestionRepository

}