package com.kt.learn

class Extent(var name: String) {
    fun foo(): Unit {
        println("Extent::foo")
        var l: MutableList<Int> = mutableListOf(1, 2, 3)
        l.swap(1, 2)
        println("swap: $l  lastIndex: ${l.lastIndex}")

        printFoo(D())
    }
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    var tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}


// 扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，具体被调用的的是哪一个函数，
// 由调用函数的的对象表达式来决定的，而不是动态的类型决定的:
open class C

class D: C()

fun C.foo() = "c"   // 扩展函数 foo

fun D.foo() = "d"   // 扩展函数 foo

fun printFoo(c: C) {
    println(c.foo())  // 类型是 C 类
}

// 扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。
// 初始化属性因为属性没有后端字段（backing field），所以不允许被初始化，只能由显式提供的 getter/setter 定义。
val <T> List<T>.lastIndex: Int
    get() = size - 1