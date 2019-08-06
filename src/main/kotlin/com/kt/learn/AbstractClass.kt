package com.kt.learn

// 这个类具有`open`属性，可以被其他类继承
open class Base {
    //`open`的方法被实现和覆写，该方法也是`open`的
    open fun f() { 
        println("Base f()")
    } 
    //`final`属性的方法，不可被覆写
    fun nf() {}
    //`open`属性的方法，可以被继承和覆写
    open val x: Int get() = 1
}

class Derived: Base() {
    override fun f() {
        println("Derived f()")
    }
}

// 抽象类和方法不需要使用open修饰
abstract class AbstractDerived: Base() {
    override abstract fun f()
}

class Outer {
    private val x: Int = 1
    var y = 2
    inner class Inner {
        fun f() = x
        fun innerTest() {
            var o = this@Outer
            println("Outer y: ${o.y}")
        }
    }
}

