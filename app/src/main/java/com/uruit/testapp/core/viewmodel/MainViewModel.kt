package com.uruit.testapp.core.viewmodel

import android.view.View
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.uruit.testapp.core.data.realm.Office
import com.uruit.testapp.core.usecase.OfficeUseCase
import io.realm.RealmResults


class MainViewModel(val useCase: OfficeUseCase) : BaseViewModel() {


    private val itemObservableArrayList = ObservableArrayList<HashMap<String, String>>()
    private val lessThan50People = MutableLiveData<Boolean>()

    init{
        isLaoding.set(true)
        lessThan50People.postValue(true)
    }


    fun lessThan50People(v : View) {
       isLaoding.set(true)
       lessThan50People.postValue(true)
    }


    fun greatherThan50People(v : View) {
        isLaoding.set(true)
        lessThan50People.postValue(false)
    }


    val liveDataOffice: LiveData<RealmResults<Office>> = Transformations.switchMap(lessThan50People) {
            lessThan -> useCase.getOffices(lessThan)
    }


    fun getOfficesObservableArrayList(): ObservableArrayList<HashMap<String, String>> {
        return itemObservableArrayList
    }

    fun addLiveData(items: List<HashMap<String, String>>) {
            isLaoding.set(false)
            itemObservableArrayList.clear()
            itemObservableArrayList.addAll(items)
    }


}