package com.shadowings.rpg98.sections.landing

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shadowings.rpg98.db.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LandingPageVM(
    database: AppDatabase
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val levels = AppDatabase.getLevels()
            database.levelDao().insertLevels(levels)

            Log.d("WIN98", database.levelDao().getAllLevels().joinToString { it.name })
        }
    }
}