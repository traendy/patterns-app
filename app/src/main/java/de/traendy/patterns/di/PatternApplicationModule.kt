package de.traendy.patterns.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import de.traendy.patterns.data.DesignPatternDataSource
import de.traendy.patterns.data.local.DesignPatternDatabase
import de.traendy.patterns.data.local.LocalDesignPatternDataSource
import de.traendy.patterns.data.repositories.DesignPatternRepository
import de.traendy.patterns.data.repositories.IDesignPatternRepository
import de.traendy.patterns.data.static.StaticDesignPatternDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module(includes = [PatternApplicationModuleBinds::class])
object PatternApplicationModule {
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DesignPatternDataSourceStatic

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DesignPatternDataSourceLocal

    @JvmStatic
    @Singleton
    @DesignPatternDataSourceStatic
    @Provides
    fun provideStaticDataSource(
    ): DesignPatternDataSource {
        return StaticDesignPatternDataSource()
    }

    @JvmStatic
    @Singleton
    @DesignPatternDataSourceLocal
    @Provides
    fun provideLocalDataSource(database: DesignPatternDatabase, ioDispatcher: CoroutineDispatcher): DesignPatternDataSource {
        return LocalDesignPatternDataSource(database.patternDao(), ioDispatcher)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @JvmStatic
    @Singleton
    @Provides
    fun provideDatabase(context: Context): DesignPatternDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            DesignPatternDatabase::class.java,
            "design_patterns.db"
        ).createFromAsset("database/design_patterns.db")
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    private val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE design_pattern_table ADD COLUMN favorite INTEGER NOT NULL DEFAULT 0")
        }
    }


}

@Module
abstract class PatternApplicationModuleBinds {
    @Singleton
    @Binds
    abstract fun bindDesignPatternRepository(repo: DesignPatternRepository): IDesignPatternRepository

}