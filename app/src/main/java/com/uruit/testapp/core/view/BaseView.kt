package com.uruit.testapp.core.view

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.uruit.testapp.core.viewmodel.BaseViewModel
import dagger.android.AndroidInjection

abstract class BaseView<D : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    lateinit var dataBinding : D
    private  var viewModel : V? = null

    abstract fun getViewModel(): V

    fun getViewDataBinding(): D {
        return dataBinding
    }

    abstract fun getBindingVariable(): Int

    @LayoutRes
    abstract fun getLayoutId(): Int

     override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    private fun performDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = if (viewModel == null) getViewModel() else viewModel
        dataBinding.setVariable(getBindingVariable(), viewModel)
        dataBinding.executePendingBindings()
    }


}