package com.istekno.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.istekno.core.base.entities.model.Instrument

class HomeAdapter(
    private val instruments: ArrayList<Instrument>,
    private val onItemClick: (instrument: Instrument) -> Unit
): RecyclerView.Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list_index, parent, false),
            onItemClick = { onItemClick(it) }
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(instruments[position])
    }

    override fun getItemCount(): Int = instruments.size
}