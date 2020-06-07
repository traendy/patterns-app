package de.traendy.patterns.ui.detail

import android.graphics.drawable.Drawable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.traendy.patterns.data.DesignPattern
import de.traendy.patterns.data.repositories.IDesignPatternRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DesignPatternDetailViewModel @Inject constructor(
    private val designPatternRepository: IDesignPatternRepository
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + SupervisorJob()
    private lateinit var job: Job

    private val _designPattern = MutableLiveData<DesignPattern>()
    val designPattern:LiveData<DesignPattern> = _designPattern

    private val _structureImage = MutableLiveData<Drawable>()
    val structureImage:LiveData<Drawable> = _structureImage

    fun loadDesignPatternById(id:Int = 0){
        launch {
            _designPattern.postValue(designPatternRepository.getDesignPatternById(id))
        }
    }

    fun updateFavoriteState() {
        val pattern = designPattern.value
        pattern?.let {
            val patternUpdated = pattern.copy(isFavorite = !pattern.isFavorite)
            launch { designPatternRepository.saveDesignPattern(patternUpdated)
            }.invokeOnCompletion {
                loadDesignPatternById(pattern.id)
            }
        }
    }

}
