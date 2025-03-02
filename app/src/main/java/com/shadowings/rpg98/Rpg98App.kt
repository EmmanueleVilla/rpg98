package com.shadowings.rpg98

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.shadowings.rpg98.db.AppDatabase
import com.shadowings.rpg98.section.system.SystemPageVM
import com.shadowings.rpg98.sections.landing.LandingPageVM
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

private object DB {
    @Volatile
    var database: AppDatabase? = null
}

fun provideAppDatabase(context: Context): AppDatabase {
    synchronized(DB) {
        if (DB.database == null) {
            DB.database = Room.databaseBuilder(
                context = context,
                AppDatabase::class.java, "rpg98-db"
            ).fallbackToDestructiveMigration()
                .build()
        }
    }
    return DB.database!!
}

val appModule = module {
    single {
        provideAppDatabase(get())
    }
    viewModelOf(::LandingPageVM)
    viewModelOf(::SystemPageVM)
}

class Rpg98App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@Rpg98App)
            modules(appModule)
        }
    }
}