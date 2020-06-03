package de.traendy.patterns.ui.main

import de.traendy.patterns.data.DesignPattern
import de.traendy.patterns.databinding.ListDesignPatternBinding
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DesignPatternListAdapter:
    ListAdapter<DesignPattern, RecyclerView.ViewHolder>(DesignPatternDiffCallback()) {

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    fun addAndSubmitList(list: List<DesignPattern>?) {
        adapterScope.launch {
            withContext(Dispatchers.Main) {
                submitList(list)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DesignPatternViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DesignPatternViewHolder).bind(
            getItem(position))
    }

    class DesignPatternViewHolder private constructor(private val binding: ListDesignPatternBinding) :
        RecyclerView.ViewHolder(binding.root), AdapterView.OnItemSelectedListener {

        override fun onNothingSelected(parent: AdapterView<*>?) {
            Log.d("Miami", "onNothingSelected")
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
            Log.d("Miami", "onItemSelected pos: " + pos + ", id: " + id)
        }

        fun bind(
            item: DesignPattern
        ) {
            binding.designPattern = item
            binding.root.setOnClickListener {
                val action =
                    MainFragmentDirections.actionMainFragmentToDesignPatternDetailFragment(item.id)
                it.findNavController().navigate(action)
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): DesignPatternViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListDesignPatternBinding.inflate(layoutInflater, parent, false)

                return DesignPatternViewHolder(
                    binding
                )
            }
        }
    }
}

class DesignPatternDiffCallback : DiffUtil.ItemCallback<DesignPattern>() {
    override fun areItemsTheSame(oldItem: DesignPattern, newItem: DesignPattern): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DesignPattern, newItem: DesignPattern): Boolean {
        return oldItem == newItem
    }
}
