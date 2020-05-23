package de.traendy.patterns.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import de.traendy.patterns.PatternsApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        PatternApplicationModule::class,
        AndroidSupportInjectionModule::class,
        MainModule::class,
        DesignPatternDetailModule::class
    ]
)
interface PatternsApplicationComponent : AndroidInjector<PatternsApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): PatternsApplicationComponent
    }
}