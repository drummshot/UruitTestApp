package com.uruit.testapp.core.viewmodel

import androidx.databinding.ObservableField
import com.uruit.testapp.core.usecase.NAME_KEY
import com.uruit.testapp.core.usecase.PEOPLE_KEY


class OfficeItemViewModel(item: HashMap<String, String>) {

    val officeName: ObservableField<String?> = ObservableField(item[NAME_KEY])
    val numberPeople: ObservableField<String?> = ObservableField(  item[PEOPLE_KEY] + " " + PEOPLE_KEY)
}
