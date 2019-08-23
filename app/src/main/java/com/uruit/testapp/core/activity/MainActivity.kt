package com.uruit.testapp.core.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.uruit.testapp.BR
import com.uruit.testapp.R
import com.uruit.testapp.core.adapter.OfficesAdapter
import com.uruit.testapp.core.data.realm.Office
import com.uruit.testapp.core.usecase.NAME_KEY
import com.uruit.testapp.core.usecase.PEOPLE_KEY
import com.uruit.testapp.core.view.BaseView
import com.uruit.testapp.core.viewmodel.MainViewModel
import com.uruit.testapp.databinding.MainBinding
import io.realm.RealmResults
import javax.inject.Inject

class MainActivity : BaseView<MainBinding, MainViewModel>() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    lateinit var adapter: OfficesAdapter
    lateinit var mainBindingBinding: MainBinding

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): MainViewModel {
        mainViewModel =
            ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel::class.java)
        return mainViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    private fun initialize() {
        adapter = OfficesAdapter(ArrayList())
        mainBindingBinding = getViewDataBinding()
        mainBindingBinding.recyclerOffices.layoutManager = LinearLayoutManager(this)
        mainBindingBinding.recyclerOffices.adapter = adapter
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        mainViewModel.liveDataOffice.observe(this, Observer<RealmResults<Office>> { t ->
            mainViewModel.addLiveData(t.toOfficeMap())
        })
    }

    fun RealmResults<Office>.toOfficeMap(): List<HashMap<String, String>> {
        val resultsArray = ArrayList<HashMap<String, String>>()

        this.let {

            for (results in it) {
                val map = HashMap<String, String>()
                map[NAME_KEY] = results.name
                map[PEOPLE_KEY] = results.peopleInOffice.toString()
                resultsArray.add(map)
            }

            mainBindingBinding.tvCount.text = getString(R.string.items, it.size.toString())
        }
        return resultsArray
    }
}




