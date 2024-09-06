package com.doyoung.vote.server.another.token
import android.content.Context
import androidx.datastore.preferences.preferencesDataStore


val Context.dataStore by preferencesDataStore(name = "settings")
