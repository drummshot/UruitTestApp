package com.uruit.testapp.di.builder

import com.uruit.testapp.core.activity.MainActivity
import com.uruit.testapp.di.module.activity.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun bindDashboardActivity(): MainActivity
}