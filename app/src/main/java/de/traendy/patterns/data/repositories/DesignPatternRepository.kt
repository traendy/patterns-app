package de.traendy.patterns.data.repositories

import de.traendy.patterns.data.DataSource
import de.traendy.patterns.data.DesignPattern
import de.traendy.patterns.di.PatternApplicationModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DesignPatternRepository @Inject constructor(
    @PatternApplicationModule.DesignPatternDataSource private val designPatternDataSource: DataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IDesignPatternRepository {
    override suspend fun getDesignPatternById(id: Int): DesignPattern {
        return withContext(ioDispatcher) {
            return@withContext designPatternDataSource.getDesignPatternById(id)
        }
    }

    override suspend fun getAllDesignPatterns(): Collection<DesignPattern> {
        return withContext(ioDispatcher) {
            return@withContext designPatternDataSource.getAllDesignPatterns()
        }
    }

    override suspend fun saveDesignPattern(designPattern: DesignPattern) {
        withContext(ioDispatcher) {
            //nothing
        }
    }
}