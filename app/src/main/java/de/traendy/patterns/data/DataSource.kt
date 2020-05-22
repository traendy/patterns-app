package de.traendy.patterns.data

interface DataSource {
    fun getDesignPatternById(id:Int):DesignPattern
    fun getAllDesignPatterns():Collection<DesignPattern>
    fun saveDesignPattern(designPattern: DesignPattern)
}