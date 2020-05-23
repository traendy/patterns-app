package de.traendy.patterns.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import de.traendy.patterns.data.DataSource
import de.traendy.patterns.data.repositories.DesignPatternRepository
import de.traendy.patterns.data.repositories.IDesignPatternRepository
import de.traendy.patterns.data.static.StaticDataSource
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module(includes = [PatternApplicationModuleBinds::class])
object PatternApplicationModule {
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DesignPatternDataSource


    @JvmStatic
    @Singleton
    @DesignPatternDataSource
    @Provides
    fun provideStaticDataSource(
    ): DataSource {
        return StaticDataSource()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}

@Module
abstract class PatternApplicationModuleBinds {
    @Singleton
    @Binds
    abstract fun bindDesignPatternRepository(repo: DesignPatternRepository): IDesignPatternRepository

}