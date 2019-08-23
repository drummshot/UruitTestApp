package com.uruit.testapp.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uruit.testapp.core.adapter.holder.OfficeViewHolder
import com.uruit.testapp.databinding.ItemBinding

class OfficesAdapter(var objectList: List<HashMap<String, String>>) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val newsViewBinding2 =
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OfficeViewHolder(newsViewBinding2)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(objectList[position])
    }

    override fun getItemCount(): Int = objectList.size

    fun addItems(offices: List<HashMap<String, String>>) {
        objectList = offices
        notifyDataSetChanged()
    }


}