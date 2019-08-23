package com.uruit.testapp.di.component

import android.app.Application
import com.uruit.testapp.application.TestApp
import com.uruit.testapp.di.builder.ActivityBuilder
import com.uruit.testapp.di.module.DaoModule
import com.uruit.testapp.di.module.SysModule
import com.uruit.testapp.di.module.UseCaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, SysModule::class,
                             DaoModule::class, UseCaseModule::class, ActivityBuilder::class])

interface SysComponent {

    fun inject(testApp: TestApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): SysComponent
    }
}