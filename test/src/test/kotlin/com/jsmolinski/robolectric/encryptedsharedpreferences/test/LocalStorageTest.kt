package com.jsmolinski.robolectric.encryptedsharedpreferences.test

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jsmolinski.robolectric.encryptedsharedpreferences.storage.LocalStorage
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LocalStorageTest {

    val subject: LocalStorage = LocalStorage(ApplicationProvider.getApplicationContext())

    @Test
    fun testLocalStorage() {
        val testValue = "TEST_VALUE"
        subject.setSomeString(testValue)

        val result = subject.getSomeString()

        assertEquals(testValue, result)
    }
}