package de.traendy.patterns.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import de.traendy.patterns.data.DesignPattern
import de.traendy.patterns.data.local.dao.DesignPatternDao

@Database(
    entities = [
        DesignPattern::class
    ],
    version = 2,
    exportSchema = true
)
abstract class DesignPatternDatabase:RoomDatabase() {
    abstract fun patternDao(): DesignPatternDao
}