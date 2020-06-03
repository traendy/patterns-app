package de.traendy.patterns.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerFragment

import de.traendy.patterns.R
import de.traendy.patterns.databinding.DesignPatternDetailFragmentBinding
import javax.inject.Inject

class DesignPatternDetailFragment : DaggerFragment() {

    companion object {
        fun newInstance() = DesignPatternDetailFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<DesignPatternDetailViewModel> { viewModelFactory }
    private val args: DesignPatternDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<DesignPatternDetailFragmentBinding>(
            inflater,
            R.layout.design_pattern_detail_fragment,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.loadDesignPatternById(args.designPatternId)
        context?.let { binding.structureImage.setImageDrawable(ContextCompat.getDrawable(it, R.drawable.strategy_pattern)) }
        return binding.root
    }



}
