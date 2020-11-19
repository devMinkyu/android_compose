package com.tag_hive.saathi.saathi.presentation.screen.common

import com.tag_hive.saathi.saathi.entity.User
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject
import javax.inject.Singleton

/// user 정보를 담고 있는 공통 ViewModel
@Singleton
class AuthViewModel @Inject constructor() {

    val user: BehaviorSubject<User> = BehaviorSubject.create()
}