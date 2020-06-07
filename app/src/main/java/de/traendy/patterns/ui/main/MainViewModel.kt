package de.traendy.patterns.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.traendy.patterns.data.DesignPattern
import de.traendy.patterns.data.repositories.IDesignPatternRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainViewModel @Inject constructor(private val designPatternRepository: IDesignPatternRepository) : ViewModel(),
    CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + SupervisorJob()
    private lateinit var job: Job

    private val _designPatterns = MutableLiveData<Collection<DesignPattern>>()
    val designPatterns: LiveData<Collection<DesignPattern>> = _designPatterns

    fun loadDesignPatterns(){
        launch {
            _designPatterns.postValue(designPatternRepository.getAllDesignPatterns())
        }
    }

    private val _searchState = MutableLiveData(false)
    val searchState: LiveData<Boolean> = _searchState

    private val _filterFavorites = MutableLiveData(false)
    val filterFavorites: LiveData<Boolean> = _filterFavorites


    fun search(searchString: String) {
        if (::job.isInitialized) job.cancel()
        job = launch(Dispatchers.IO)
        {
            yield() // stop if canceled
            // Heavy work
            val result = designPatternRepository.getDesignPatterns(searchString)
            // return if canceled
            yield()
            // post if not canceled
            _designPatterns.postValue(result)
        }
    }

    fun filterFavorites(filter:Boolean){
        launch {
            _designPatterns.postValue( designPatternRepository.getFavoriteDesignPatterns( filter ))
        }
    }

    fun transferToSearchState(isActive: Boolean){
        _searchState.postValue(isActive)
    }

    fun transferToFilterState(isFiltered: Boolean) {
        _filterFavorites.postValue(isFiltered)
    }
}
