package com.kt.learn

// main constructor
class Persion constructor(var name: String) {
    init {
        println("initializer static code")
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