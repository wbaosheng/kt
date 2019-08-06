package com.kt.learn

class Persion constructor(var name: String) {
    // main constructor
    init {
        println("main constructor $name")
    }

    // second constructor
    constructor (name: String, age: Int): this(name) {
        println("second constructor $name $age")
    }

    // var <propertyName>[: <PropertyType>] [= <property_initializer>]
    // [<getter>]
    // [<setter>]
    var largeName: String = "wang"
        get() = name.toUpperCase()
        set

    var no: Int = 100
        get() = field
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }

    var height: Float = 100.0f
        private set
}