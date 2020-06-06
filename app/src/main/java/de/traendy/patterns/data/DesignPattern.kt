package de.traendy.patterns.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "design_pattern_table")
data class DesignPattern(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    val id: Int = 0,
    @ColumnInfo(name = "title")
    @NonNull
    val title: String = "",
    @ColumnInfo(name = "description")
    @NonNull
    val description: String = "",
    @ColumnInfo(name = "structure")
    val structure: String? = null
)