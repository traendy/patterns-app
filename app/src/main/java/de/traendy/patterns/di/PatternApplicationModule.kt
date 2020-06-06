package de.traendy.patterns.di

import android.content.Context
import androidx.room.Room
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
            .build()
    }


}

@Module
abstract class PatternApplicationModuleBinds {
    @Singleton
    @Binds
    abstract fun bindDesignPatternRepository(repo: DesignPatternRepository): IDesignPatternRepository

}