package com.tag_hive.saathi.saathi.presentation.screen.common

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import timber.log.Timber

abstract class BaseViewModel :ViewModel() {
    companion object {
        val TAG: String = BaseViewModel::class.java.simpleName
    }
    var isInitialized = false
    open fun initialize() {
        isInitialized = true
    }

//    에러 공동 처리
    protected val onError: (Throwable) -> Unit = {
        Timber.d(it)
    }
    /**
     * CoroutineScope 내부 Exception 처리 Handler
     */
    protected val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        throwable.printStackTrace()
    }

    /**
     * Dispatchers 선언 (Normal Dispatchers + CoroutineExceptionHandler)
     */
    protected val ioDispatchers = Dispatchers.IO + coroutineExceptionHandler
    protected val uiDispatchers = Dispatchers.Main + coroutineExceptionHandler

    /**
     * Clear Rx when called onCleared
     */
    private val compositeDisposable = CompositeDisposable()

    @Synchronized
    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}