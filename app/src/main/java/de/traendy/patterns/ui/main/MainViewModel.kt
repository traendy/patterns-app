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
}
