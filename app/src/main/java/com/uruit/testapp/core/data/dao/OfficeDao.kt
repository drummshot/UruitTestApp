package com.uruit.testapp.core.data.dao

import androidx.lifecycle.LiveData
import com.uruit.testapp.core.data.realm.Office
import io.realm.Realm
import io.realm.RealmResults


class OfficeDao (val realm: Realm) : BaseDao() {

    fun query(greatherThan :Int, lessThan : Int): LiveData<RealmResults<Office>> {
        return realm.where(Office::class.java)
            .greaterThan("peopleInOffice", greatherThan)
            .lessThan("peopleInOffice", lessThan)
            .findAllAsync()
            .asLiveData()
    }

    fun save(office: Office) {
        realm.executeTransactionAsync { realm1 -> realm1.copyToRealmOrUpdate(office) }
    }

    fun count(): Long {
        return realm.where(Office::class.java).count()
    }

    fun getById(id : Int) : Office? {
        return realm.where(Office::class.java).equalTo("id", id).findFirst()
    }

    fun getCopyById(i: Int): Office? {
        return realm.copyFromRealm(getById(i))
    }

    fun count(greatherThan: Int, lessThan: Int) : Long {
        return realm.where(Office::class.java)
            .greaterThan("peopleInOffice", greatherThan)
            .lessThan("peopleInOffice", lessThan)
            .count()
    }
}