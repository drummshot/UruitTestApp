package com.uruit.testapp.core.data.dao.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.uruit.testapp.application.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class BaseViewModel(private val schedulerProvider: SchedulerProvider)  : ViewModel() {

    private val compositeDisposable : CompositeDisposable = CompositeDisposable()
    private var isLaoding : ObservableBoolean = ObservableBoolean(false)

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
