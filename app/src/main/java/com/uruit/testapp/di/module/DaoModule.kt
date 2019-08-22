package com.uruit.testapp.di.module

import com.uruit.testapp.core.data.dao.OfficeDao
import dagger.Module
import dagger.Provides
import io.realm.Realm
import javax.inject.Singleton


@Module
class DaoModule {

    @Provides
    @Singleton
    fun providesOfficeDao(realm : Realm): OfficeDao {
        return OfficeDao(realm)
    }

}