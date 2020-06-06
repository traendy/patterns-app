package de.traendy.patterns.data

interface DesignPatternDataSource {
    suspend fun getDesignPatternById(id:Int):DesignPattern
    suspend fun getAllDesignPatterns():Collection<DesignPattern>
    suspend fun getDesignPatternsBySearchString(searchString:String):Collection<DesignPattern>
    suspend fun saveDesignPattern(designPattern: DesignPattern)
}