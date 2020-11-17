package com.example.mycompose.ioc.module.injector


import com.example.mycompose.ioc.module.provider.AppProviderModule
import com.example.mycompose.presentation.screen.MainActivity
import dagger.Module

@Module(
    includes = [
        AppProviderModule::class
    ]
)
@Suppress("unused")
interface AppInjectorModule {
    fun mainActivity(): MainActivity

}