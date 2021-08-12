package com.istekno.features.home

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.istekno.core.base.entities.model.Instrument
import com.istekno.features.home.databinding.ItemListIndexBinding

class HomeViewHolder(val binding: ItemListIndexBinding, val onItemClick: (instrument: Instrument) -> Unit): RecyclerView.ViewHolder(binding.root) {
    fun bind(instrument: Instrument) {
        setupView(instrument)
        setTextChange(instrument.change_day, instrument.change_day_percent)
        binding.root.setOnClickListener { onItemClick(instrument) }
    }

    private fun setupView(instrument: Instrument) {
        binding.apply {
            tvIndexName.text = instrument.index
            tvIndexFullname.text = instrument.name
            tvPrice.text = instrument.price.toString()
        }
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    private fun setTextChange(value: Double, percent: Double) {
        binding.tvChange.apply {
            context.let {
                when {
                    value == 0.0 -> setTextColor(it.resources.getColor(R.color.subtitle))
                    value > 0.0 -> setTextColor(it.resources.getColor(R.color.theme_green))
                    value < 0.0 -> setTextColor(it.resources.getColor(R.color.red))
                }
            }

            text = if (value > 0) "+${value}(+${percent}%)" else "${value}(${percent}%)"
        }
    }
}