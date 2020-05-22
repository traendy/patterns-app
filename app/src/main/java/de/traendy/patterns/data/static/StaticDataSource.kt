package de.traendy.patterns.data.static

import de.traendy.patterns.data.DataSource
import de.traendy.patterns.data.DesignPattern

class StaticDataSource :DataSource {

    private val strategyPattern = DesignPattern(
        id = 1,
        title = "Strategy Pattern",
        description = "Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it."
    )

    override fun getDesignPatternById(id: Int):DesignPattern = strategyPattern

    override fun getAllDesignPatterns():Collection<DesignPattern> = listOf(strategyPattern)

    override fun saveDesignPattern(designPattern: DesignPattern) {
        //nothing
    }
}