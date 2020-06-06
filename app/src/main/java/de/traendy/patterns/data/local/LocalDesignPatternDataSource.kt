package de.traendy.patterns.data.local

import de.traendy.patterns.data.DesignPatternDataSource
import de.traendy.patterns.data.DesignPattern
import de.traendy.patterns.data.local.dao.DesignPatternDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class LocalDesignPatternDataSource internal constructor(
    private val patternDao: DesignPatternDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : DesignPatternDataSource {
    override suspend fun getDesignPatternById(id: Int): DesignPattern = withContext(ioDispatcher){
        return@withContext patternDao.getDesignPatternById(id)
    }

    override suspend fun getAllDesignPatterns(): Collection<DesignPattern> = withContext(ioDispatcher) {
        return@withContext patternDao.getAllDesignPatterns()
    }

    override suspend fun getDesignPatternsBySearchString(searchString: String): Collection<DesignPattern> =
        withContext(ioDispatcher) {
            return@withContext patternDao.getAllDesignPatterns().filter {
                it.title.contains(searchString)
            }
    }

    override suspend fun saveDesignPattern(designPattern: DesignPattern) {
        patternDao.insert(designPattern)
    }
}