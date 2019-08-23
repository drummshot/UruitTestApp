package com.uruit.testapp.core.adapter.holder

import com.uruit.testapp.core.adapter.BaseViewHolder
import com.uruit.testapp.core.viewmodel.OfficeItemViewModel
import com.uruit.testapp.databinding.ItemBinding

class OfficeViewHolder(private val mBinding: ItemBinding) : BaseViewHolder(mBinding.getRoot()) {
    private var genericItemViewModel: OfficeItemViewModel? = null

    override fun onBind(position: Any) {
        genericItemViewModel = OfficeItemViewModel(position as HashMap<String, String>)
        mBinding.itemViewModel = genericItemViewModel
        mBinding.executePendingBindings()
    }
}