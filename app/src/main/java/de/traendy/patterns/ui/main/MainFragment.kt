package de.traendy.patterns.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import de.traendy.patterns.MainActivity
import de.traendy.patterns.R
import de.traendy.patterns.data.DesignPattern
import de.traendy.patterns.ui.utils.SearchTextWatcher
import de.traendy.patterns.ui.utils.setMenu
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<MainViewModel> { viewModelFactory }
    private lateinit var adapter: DesignPatternListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        setMenu(R.menu.top_app_bar)
        adapter = DesignPatternListAdapter()
        viewModel.designPatterns.observe(viewLifecycleOwner, Observer {
            adapter.addAndSubmitList(it as List<DesignPattern>)
        })
        viewModel.searchState.observe(viewLifecycleOwner, Observer {
            if(it){
                main.transitionToEnd()
            }else{
                main.transitionToStart()
            }
        })
        viewModel.loadDesignPatterns()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search -> {viewModel.transferToSearchState(!viewModel.searchState.value!!)
                true}
                else -> false
            }
        }
        searchEditText.addTextChangedListener(SearchTextWatcher(viewModel::search))
        designPatternRecyclerView.adapter = adapter
    }



}
