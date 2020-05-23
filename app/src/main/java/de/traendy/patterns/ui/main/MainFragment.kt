package de.traendy.patterns.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import de.traendy.patterns.R
import de.traendy.patterns.databinding.MainFragmentBinding
import de.traendy.patterns.di.ViewModelFactory
import de.traendy.patterns.di.ViewModelFactory_Factory
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<MainViewModel> { viewModelFactory }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = DataBindingUtil.inflate<MainFragmentBinding>(
                inflater,
                R.layout.main_fragment,
                container,
                false
        )
        binding.lifecycleOwner = this
        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_designPatternDetailFragment)
        }
        Log.d("TEST", viewModel.toString())
        return binding.root
    }



}
