package com.uruit.testapp.core.utils


import android.view.View
import androidx.core.widget.ContentLoadingProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uruit.testapp.core.adapter.OfficesAdapter


object BindingUtils {

    @JvmStatic
    @BindingAdapter("adapter")
    fun addOffices(recyclerView: RecyclerView?, offices: List<HashMap<String, String>>?) {
        val adapter = recyclerView?.adapter as? OfficesAdapter
        if (offices != null) {
            adapter?.addItems(offices)
        }
    }

    @JvmStatic
    @BindingAdapter("visibility")
    fun showLoader(loader: ContentLoadingProgressBar?, show : Boolean) {
        loader?.visibility = if(show) View.VISIBLE else  View.GONE
    }
}
