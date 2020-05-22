package de.traendy.patterns

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import de.traendy.patterns.di.DaggerApplicationComponent

class PatternsApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }
}