package com.tag_hive.saathi.saathi.data.local

import android.content.SharedPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Suppress("unused")
@Singleton
class AndroidPrefUtilService @Inject constructor() {
    @Inject
    lateinit var sp: SharedPreferences

    fun hasKey(key: Key): Boolean {
        return sp.contains(key.name)
    }

    fun remove(key: Key) {
        sp.edit().remove(key.name).apply()
    }

    fun clearAll() {
        sp.edit().clear().apply()
    }

    fun getInt(key: Key): Int {
        return sp.getInt(key.name, -1)
    }

    fun getInt(key: Key, defaultVal: Int): Int {
        return sp.getInt(key.name, defaultVal)
    }

    fun getString(key: Key): String {
        return sp.getString(key.name, "")!!
    }

    fun getString(key: Key, defaultVal: String): String {
        return sp.getString(key.name, defaultVal)!!
    }

    fun getStringSet(key: Key, defaultVal: Set<String>): Set<String> {
        return sp.getStringSet(key.name, defaultVal)!!
    }

    fun getBool(key: Key): Boolean {
        return getBool(key, false)
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun getBool(key: Key, defaultVal: Boolean): Boolean {
        return sp.getBoolean(key.name, defaultVal)
    }

    fun getFloat(key: Key): Float {
        return sp.getFloat(key.name, 0f)
    }

    fun getLong(key: Key, value: Long): Long {
        return sp.getLong(key.name, value)
    }

    fun putInt(key: Key, value: Int): Flow<Any> {
        return flow<Any> {
            emit(sp.edit().putInt(key.name, value).apply())
        }
    }

    fun putString(key: Key, value: String): Flow<Any>  {
        return flow<Any> {
            emit(sp.edit().putString(key.name, value).apply())
        }
    }

    fun putStringSet(key: Key, value: Set<String>): Flow<Any>  {
        return flow<Any> {
            emit(sp.edit().putStringSet(key.name, value).apply())
        }
    }

    fun putBool(key: Key, value: Boolean): Flow<Any>  {
        return flow<Any> {
            emit(sp.edit().putBoolean(key.name, value).apply())
        }
    }

    fun putFloat(key: Key, value: Float): Flow<Any>  {
        return flow<Any> {
            emit(sp.edit().putFloat(key.name, value).apply())
        }
    }

    fun putLong(key: Key, value: Long): Flow<Any>  {
        return flow<Any> {
            emit(sp.edit().putLong(key.name, value).apply())
        }
    }

    enum class Key {
        FAVORITE_ID
    }
}