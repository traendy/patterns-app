package de.traendy.patterns.data.repositories

import de.traendy.patterns.data.DesignPatternDataSource
import de.traendy.patterns.data.DesignPattern
import de.traendy.patterns.di.PatternApplicationModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DesignPatternRepository @Inject constructor(
    @PatternApplicationModule.DesignPatternDataSourceLocal private val designPatternDesignPatternDataSource: DesignPatternDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IDesignPatternRepository {
    override suspend fun getDesignPatternById(id: Int): DesignPattern {
        return withContext(ioDispatcher) {
            return@withContext designPatternDesignPatternDataSource.getDesignPatternById(id)
        }
    }

    override suspend fun getAllDesignPatterns(): Collection<DesignPattern> {
        return withContext(ioDispatcher) {
            return@withContext designPatternDesignPatternDataSource.getAllDesignPatterns()
        }
    }

    override suspend fun saveDesignPattern(designPattern: DesignPattern) {
        withContext(ioDispatcher) {
            designPatternDesignPatternDataSource.saveDesignPattern(designPattern)
        }
    }

    override suspend fun getDesignPatterns(searchString: String): Collection<DesignPattern> {
        return withContext(ioDispatcher) {
            return@withContext designPatternDesignPatternDataSource.getDesignPatternsBySearchString(searchString)
        }
    }

    override suspend fun getFavoriteDesignPatterns(isFavorite: Boolean): Collection<DesignPattern> {
        return withContext(ioDispatcher) {
            if (isFavorite) {
                return@withContext designPatternDesignPatternDataSource.getAllDesignPatterns()
                    .filter { it.isFavorite }
            } else {
                return@withContext designPatternDesignPatternDataSource.getAllDesignPatterns()
            }
        }
    }
}