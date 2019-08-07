package com.kt.learn

fun objectExpress() {
    // 对象表达式
    var site = object {
        var name = "Runoob"
        var url = "www.runoob.com"
    }
    println("name: ${site.name} url: ${site.url}")

    Instance.foo()
}

// 1. 对象表达式
private class Co {
    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // 没问题
        // val x2 = publicFoo().x  // 错误：未能解析的引用“x”
    }
}

// 2. 对象声明，可以声明单例
object Instance {
    var name = "instance"

    fun foo() {
        println("object instance class")
    }
}