package com.uruit.testapp.core.data.dao

import com.uruit.testapp.core.data.realm.RealmLiveData
import io.realm.RealmModel
import io.realm.RealmResults

abstract class BaseDao {

    fun <T: RealmModel> RealmResults<T>.asLiveData() = RealmLiveData<T>(this)
}