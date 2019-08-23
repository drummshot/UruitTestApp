package com.uruit.testapp.core.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

     var isLaoding : ObservableBoolean = ObservableBoolean(false)
}
