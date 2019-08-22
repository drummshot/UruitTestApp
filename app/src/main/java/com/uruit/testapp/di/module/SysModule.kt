package com.uruit.testapp.di.module

import android.content.Context
import com.uruit.testapp.application.TestApp
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
class SysModule {


    @Provides
    @Singleton
    fun provideApplication(app: TestApp): Context = app


    @Provides
    @Singleton
    internal fun provideRealm(ctx: Context): Realm {
        Realm.init(ctx)

        Realm.setDefaultConfiguration(
            RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        )

        return Realm.getDefaultInstance()
    }
}