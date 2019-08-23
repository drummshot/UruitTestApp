package com.uruit.testapp.di.module

import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
class SysModule {

    @Provides
    @Singleton
    internal fun provideRealm(): Realm {

        Realm.setDefaultConfiguration(
            RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        )

        return Realm.getDefaultInstance()
    }
}