package com.example.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.databinding.ListItemCrimeBinding
import com.example.criminalintent.databinding.ListItemSeriousCrimeBinding
import com.google.android.material.snackbar.Snackbar

class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_NORMAL = 0
        private const val TYPE_SERIOUS = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (crimes[position].requiresPolice) TYPE_SERIOUS else TYPE_NORMAL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_NORMAL) {
            val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
            CrimeHolder(binding)
        } else {
            val binding = ListItemSeriousCrimeBinding.inflate(inflater, parent, false)
            SeriousCrimeHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val crime = crimes[position]
        when (holder) {
            is CrimeHolder -> holder.bind(crime)
            is SeriousCrimeHolder -> holder.bind(crime) // Обработка особо опасных преступлений
        }
    }

    override fun getItemCount() = crimes.size

    class CrimeHolder(
        private val binding: ListItemCrimeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(crime: Crime) {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()
            binding.root.setOnClickListener {
                Snackbar.make(
                    binding.root,
                    "${crime.title} clicked!",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    class SeriousCrimeHolder(
        private val binding: ListItemSeriousCrimeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(crime: Crime) {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()
            binding.contactPoliceButton.setOnClickListener {
                // код для обработки нажатия кнопки "связаться с полицией"
            }
        }
    }
}
