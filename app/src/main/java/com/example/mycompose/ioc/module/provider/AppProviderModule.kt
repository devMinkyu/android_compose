package com.example.mycompose.ioc.module.provider

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module(
    includes =
    [
        NetworkProviderModule::class
    ]
)
@InstallIn(ApplicationComponent::class)
class AppProviderModule {
    @Provides
    internal fun providePreferenceManager(@ApplicationContext context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    internal fun provideRes(@ApplicationContext context: Context): Resources {
        return context.resources
    }
}