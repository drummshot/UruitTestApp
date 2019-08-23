package com.uruit.testapp.di.module

import com.uruit.testapp.core.data.dao.OfficeDao
import com.uruit.testapp.core.usecase.OfficeUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun providesOfficeUSeCase(officeDao: OfficeDao ): OfficeUseCase {
        return OfficeUseCase(officeDao)
    }
}