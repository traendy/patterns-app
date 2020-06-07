package de.traendy.patterns.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerFragment
import de.traendy.patterns.MainActivity

import de.traendy.patterns.R
import de.traendy.patterns.databinding.DesignPatternDetailFragmentBinding
import de.traendy.patterns.ui.utils.setFavoriteIcon
import de.traendy.patterns.ui.utils.setMenu
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject

class DesignPatternDetailFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<DesignPatternDetailViewModel> { viewModelFactory }
    private val args: DesignPatternDetailFragmentArgs by navArgs()
    private lateinit var binding: DesignPatternDetailFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.design_pattern_detail_fragment,
            container,
            false
        )
        setMenu(R.menu.top_app_bar_details)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.loadDesignPatternById(args.designPatternId)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.structureImageContainer.addDragView(binding.structureImage)
        (activity as MainActivity).topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.favorite -> {
                    viewModel.updateFavoriteState()
                    true
                }
                else -> false
            }
        }
        viewModel.designPattern.observe(viewLifecycleOwner, Observer {
            setFavoriteIcon(it.isFavorite)
        })
    }





}
