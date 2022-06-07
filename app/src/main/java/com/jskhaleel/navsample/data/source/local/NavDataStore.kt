package com.jskhaleel.navsample.data.source.local

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.firstOrNull

/**
 * Created by Khaleel Jageer on 06/06/22.
 */
class NavDataStore(private val context: Context) {
    private val Context.preferenceStore by preferencesDataStore(name = PREFERENCE_NAME)

    suspend fun login() {
        context.preferenceStore.edit {
            it[KEY_LOGIN] = true.toString()
        }
    }

    suspend fun isUserLogged(): Boolean {
        val pref: Preferences? = context.preferenceStore.data.firstOrNull()
        return pref?.get(KEY_LOGIN)?.toBoolean() ?: false
    }

    suspend fun logout() {
        context.preferenceStore.edit {
            it.clear()
        }
    }

    companion object {
        private const val PREFERENCE_NAME = "nav_sample_pref"
        private val KEY_LOGIN = stringPreferencesKey("key.login")
    }
}