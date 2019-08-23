package com.uruit.testapp.core.data.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Office(@PrimaryKey var id : Int, var name : String, var peopleInOffice : Int) : RealmObject() {

    constructor() : this( 0,"", 0)
}