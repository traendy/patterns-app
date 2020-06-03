package de.traendy.patterns.data.static

import de.traendy.patterns.R
import de.traendy.patterns.data.DataSource
import de.traendy.patterns.data.DesignPattern

class StaticDataSource :DataSource {

    private val patterns = listOf(
        DesignPattern(
            id = 1,
            title = "Strategy",
            description = "Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.",
            structure = R.drawable.strategy
        ),
        DesignPattern(
            id = 2,
            title = "Abstract Factory",
            description = "Placeholder",
            structure = R.drawable.abstract_factory
        ),
        DesignPattern(
            id = 3,
            title = "Adapter",
            description = "Placeholder",
            structure = R.drawable.adapter
        ),
        DesignPattern(
            id = 4,
            title = "Bridge",
            description = "Placeholder",
            structure = R.drawable.bridge
        ),
        DesignPattern(
            id = 5,
            title = "Builder",
            description = "Placeholder",
            structure = R.drawable.builder
        ),
        DesignPattern(
            id = 6,
            title = "Chain of Responsibility",
            description = "Placeholder",
            structure = R.drawable.chainofresponsibility
        ),
        DesignPattern(
            id = 7,
            title = "Command",
            description = "Placeholder",
            structure = R.drawable.command
        ),
        DesignPattern (
            id = 8,
            title = "Composite",
            description = "Placeholder",
            structure = R.drawable.composite
        ),
        DesignPattern(
            id = 9,
            title = "Decorator",
            description = "Placeholder",
            structure = R.drawable.decorator
        ),
        DesignPattern(
            id = 10,
            title = "Facade",
            description = "Placeholder",
            structure = R.drawable.facade
        ),
        DesignPattern(
            id = 11,
            title = "Factory Method",
            description = "Placeholder",
            structure = R.drawable.factorymethod
        ),
        DesignPattern(
            id = 12,
            title = "Flyweight",
            description = "Placeholder",
            structure = R.drawable.flyweight
        ),
        DesignPattern(
            id = 13,
            title = "Interpreter",
            description = "Placeholder",
            structure = R.drawable.interpreter
        ),
        DesignPattern(
            id = 14,
            title = "Iterator",
            description = "Placeholder",
            structure = R.drawable.iterator
        ),
        DesignPattern(
            id = 15,
            title = "Mediator",
            description = "Placeholder",
            structure = R.drawable.mediator
        ),
        DesignPattern(
            id = 16,
            title = "Memento",
            description = "Placeholder",
            structure = R.drawable.memento
        ),
        DesignPattern(
            id = 17,
            title = "Null Object",
            description = "Placeholder",
            structure = R.drawable.nullobject
        ),
        DesignPattern(
            id = 18,
            title = "Observer",
            description = "Placeholder",
            structure = R.drawable.observer
        ),
        DesignPattern(
            id = 19,
            title = "Prototype",
            description = "Placeholder",
            structure = R.drawable.prototype
        ),
        DesignPattern(
            id = 20,
            title = "Proxy",
            description = "Placeholder",
            structure = R.drawable.proxy
        ),
        DesignPattern(
            id = 21,
            title = "Singleton",
            description = "Placeholder",
            structure = R.drawable.singleton
        ),
        DesignPattern(
            id = 22,
            title = "State",
            description = "Placeholder",
            structure = R.drawable.state
        ),
        DesignPattern(
            id = 23,
            title = "Template Method",
            description = "Placeholder",
            structure = R.drawable.templatemethod
        ),
        DesignPattern(
            id = 24,
            title = "Visitor",
            description = "Placeholder",
            structure = R.drawable.visitor
        )
    )

    private val nullDesignPattern = DesignPattern(
        id = 17,
        title = "Null Object",
        description = "Placeholder",
        structure = R.drawable.nullobject
    )

    override fun getDesignPatternById(id: Int):DesignPattern = patterns.firstOrNull{ it.id == id }?: nullDesignPattern

    override fun getAllDesignPatterns():Collection<DesignPattern> = patterns

    override fun saveDesignPattern(designPattern: DesignPattern) {
        //nothing
    }
}