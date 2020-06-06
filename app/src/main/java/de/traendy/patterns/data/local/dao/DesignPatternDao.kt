package de.traendy.patterns.data.local.dao

import androidx.room.*
import de.traendy.patterns.data.DesignPattern

@Dao
interface DesignPatternDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(limit: DesignPattern)

    @Query("DELETE FROM design_pattern_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM design_pattern_table ORDER BY title DESC")
    suspend fun getAllDesignPatterns(): List<DesignPattern>

    @Delete
    suspend fun deleteDesignPattern(limit: DesignPattern)

    @Query("SELECT * FROM design_pattern_table WHERE id = :patternId LIMIT 1")
    fun getDesignPatternById(patternId: Int): DesignPattern
}