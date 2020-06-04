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
            description = "Provides an interface to create related objects without knowing their concrete classes.",
            structure = R.drawable.abstract_factory
        ),
        DesignPattern(
            id = 3,
            title = "Adapter",
            description = "Adapter converts an interface into another and allows classes to work together that otherwise could not.",
            structure = R.drawable.adapter
        ),
        DesignPattern(
            id = 4,
            title = "Bridge",
            description = "Decouples an abstraction from its implementation so that they can vary independently.",
            structure = R.drawable.bridge
        ),
        DesignPattern(
            id = 5,
            title = "Builder",
            description = "Separate the construction of an object from its representation so that the same construction process can create a different representation.",
            structure = R.drawable.builder
        ),
        DesignPattern(
            id = 6,
            title = "Chain of Responsibility",
            description = "Chains the receiving object and passes the request to a chain until one object in this chain can handle the request.",
            structure = R.drawable.chainofresponsibility
        ),
        DesignPattern(
            id = 7,
            title = "Command",
            description = "Wraps a request in an object. Allows parameterize the request, queue, log ist and supports to reverse the request.",
            structure = R.drawable.command
        ),
        DesignPattern (
            id = 8,
            title = "Composite",
            description = "Compose objects into tree structures. Allows to treat individual and composite objects uniformly.",
            structure = R.drawable.composite
        ),
        DesignPattern(
            id = 9,
            title = "Decorator",
            description = "Add additional responsibilities to an object dynamically. It is an alternative to subclassing.",
            structure = R.drawable.decorator
        ),
        DesignPattern(
            id = 10,
            title = "Facade",
            description = "Provides an interface to a set of interfaces of a complex subsystem.",
            structure = R.drawable.facade
        ),
        DesignPattern(
            id = 11,
            title = "Factory Method",
            description = "Defines an interface for creating an object but let subclasses decide which one.",
            structure = R.drawable.factorymethod
        ),
        DesignPattern(
            id = 12,
            title = "Flyweight",
            description = "Uses sharing to support the use of a lot of small objects by reusing them.",
            structure = R.drawable.flyweight
        ),
        DesignPattern(
            id = 13,
            title = "Interpreter",
            description = "Combined with a grammar it can be used to interpret sentences in a language.",
            structure = R.drawable.interpreter
        ),
        DesignPattern(
            id = 14,
            title = "Iterator",
            description = "Interface to access elements of an aggregation of objects without exposing the aggregations representation.",
            structure = R.drawable.iterator
        ),
        DesignPattern(
            id = 15,
            title = "Mediator",
            description = "An Object that encapsulates how a set of objects interact. Thus these objects do not need to know each other but the Mediator.",
            structure = R.drawable.mediator
        ),
        DesignPattern(
            id = 16,
            title = "Memento",
            description = "Captures an objects internal state and make it able to restore the state later.",
            structure = R.drawable.memento
        ),
        DesignPattern(
            id = 17,
            title = "Null Object",
            description = "Tries to resolve the problem and need to use null. By defining default implementations to an object.",
            structure = R.drawable.nullobject
        ),
        DesignPattern(
            id = 18,
            title = "Observer",
            description = "Defines a one to many dependency between objects. This allows to propagate change in one object to all its dependants.",
            structure = R.drawable.observer
        ),
        DesignPattern(
            id = 19,
            title = "Prototype",
            description = "Using a prototypical instance of an object to create new ones by copying.",
            structure = R.drawable.prototype
        ),
        DesignPattern(
            id = 20,
            title = "Proxy",
            description = "Provides a placeholder between to objects to control access to one of them.",
            structure = R.drawable.proxy
        ),
        DesignPattern(
            id = 21,
            title = "Singleton",
            description = "Ensures a class has only one instance.",
            structure = R.drawable.singleton
        ),
        DesignPattern(
            id = 22,
            title = "State",
            description = "Allows to change the behavior of an object if its internal state changes.",
            structure = R.drawable.state
        ),
        DesignPattern(
            id = 23,
            title = "Template Method",
            description = "Defines a skeleton of an algorithm with the possibility to change parts of it.",
            structure = R.drawable.templatemethod
        ),
        DesignPattern(
            id = 24,
            title = "Visitor",
            description = "Allows the definition of a new operation without changing the class of elements on which it operates.",
            structure = R.drawable.visitor
        )
    )

    private val nullDesignPattern = DesignPattern(
        id = 17,
        title = "Null Object",
        description = "Tries to resolve the problem and need to use null. By defining default implementations to an object.",
        structure = R.drawable.nullobject
    )

    override fun getDesignPatternById(id: Int):DesignPattern = patterns.firstOrNull{ it.id == id }?: nullDesignPattern

    override fun getAllDesignPatterns():Collection<DesignPattern> = patterns

    override fun getDesignPatterns(searchString: String): Collection<DesignPattern> {
        return patterns.filter {
            it.title.contains(searchString)
        }
    }

    override fun saveDesignPattern(designPattern: DesignPattern) {
    }
}