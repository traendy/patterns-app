package de.traendy.patterns.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import de.traendy.patterns.ui.detail.DesignPatternDetailFragment
import de.traendy.patterns.ui.detail.DesignPatternDetailViewModel

@Module
abstract class DesignPatternDetailModule {
    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun designPatternDetailFragment(): DesignPatternDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(DesignPatternDetailViewModel::class)
    abstract fun bindsDesignPatternViewModel(viewModel: DesignPatternDetailViewModel): ViewModel

}