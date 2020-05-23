package de.traendy.patterns.data.repositories

import de.traendy.patterns.data.DesignPattern

interface IDesignPatternRepository {
    suspend fun getDesignPatternById(id: Int): DesignPattern
    suspend fun getAllDesignPatterns(): Collection<DesignPattern>
    suspend fun saveDesignPattern(designPattern: DesignPattern)
}