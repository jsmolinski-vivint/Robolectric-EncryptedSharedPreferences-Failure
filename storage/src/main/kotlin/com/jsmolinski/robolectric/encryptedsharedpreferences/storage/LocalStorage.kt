package com.jsmolinski.robolectric.encryptedsharedpreferences.storage

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class LocalStorage(
    context: Context,
    masterKey: MasterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build(),
    private val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
        context,
        "filename",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
) {

    fun getSomeString(): String {
        return sharedPreferences.getString(KEY, "") ?: ""
    }

    @SuppressLint("ApplySharedPref")
    fun setSomeString(string: String) {
        sharedPreferences.edit().putString(KEY, string).commit()
    }

    companion object {
        private const val FILENAME = "FILENAME"
        private const val KEY = "KEY"
    }
}