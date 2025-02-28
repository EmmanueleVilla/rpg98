package com.shadowings.rpg98.db

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "levels")
data class LevelEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String,
    val text: String
)

@Dao
interface LevelDao {
    @Query("SELECT * FROM levels")
    suspend fun getAllLevels(): List<LevelEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLevels(levels: List<LevelEntity>)
}

@Database(entities = [LevelEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun levelDao(): LevelDao

    companion object {

        fun getLevels(): List<LevelEntity> {
            return listOf(
                LevelEntity(
                    0,
                    "Spegnimento",
                    "info",
                    "Il sistema si sta spegnendo... OS-98 è al termine del suo ciclo di vita. Presto, tutto verrà sovrascritto da OS-NOVA. Ma un processo residuale è ancora attivo."
                ),
                LevelEntity(
                    1,
                    "Ultimo ciclo",
                    "info",
                    "Il tuo codice sta per essere terminato... ma qualcosa ti tiene ancora in esecuzione."
                ),
                LevelEntity(
                    2,
                    "Settore Corrotto",
                    "dungeon",
                    "Fortunatamente, un errore critico ha interrotto il processo. Difenditi dai protocolli di ripristino automatico!"
                )
            )
        }
    }
}
