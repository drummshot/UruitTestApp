package com.uruit.testapp.di.module.activity

import androidx.lifecycle.ViewModelProvider
import com.uruit.testapp.core.usecase.OfficeUseCase
import com.uruit.testapp.core.viewmodel.MainViewModel
import com.uruit.testapp.core.viewmodel.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun providesMainViewModel(useCase: OfficeUseCase): MainViewModel {
        return MainViewModel(useCase)
    }

    @Provides
    fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }
}
