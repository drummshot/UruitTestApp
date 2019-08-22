package com.uruit.testapp.di.module

import com.uruit.testapp.application.AppSchedulersProvider
import com.uruit.testapp.application.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SchedulersModule {

    @Provides
    @Singleton
    fun providesSchedulersProvider(): SchedulerProvider {
        return AppSchedulersProvider()
    }
}