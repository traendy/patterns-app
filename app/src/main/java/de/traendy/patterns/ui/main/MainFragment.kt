package de.traendy.patterns.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import de.traendy.patterns.R
import de.traendy.patterns.data.DesignPattern
import de.traendy.patterns.databinding.MainFragmentBinding
import de.traendy.patterns.di.ViewModelFactory
import de.traendy.patterns.di.ViewModelFactory_Factory
import de.traendy.patterns.ui.utils.SearchTextWatcher
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<MainViewModel> { viewModelFactory }
    private lateinit var binding:MainFragmentBinding
    private lateinit var adapter: DesignPatternListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate<MainFragmentBinding>(
                inflater,
                R.layout.main_fragment,
                container,
                false
        )
        binding.lifecycleOwner = this
        adapter = DesignPatternListAdapter()

        viewModel.designPatterns.observe(viewLifecycleOwner, Observer {
            adapter.addAndSubmitList(it as List<DesignPattern>)
        })
        viewModel.loadDesignPatterns()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchEditText.addTextChangedListener(SearchTextWatcher(viewModel::search))
        binding.designPatternRecyclerView.adapter = adapter
    }



}
