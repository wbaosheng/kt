package com.kt.learn

fun genericType(): Unit {
    println("Generic type")
    var box = Box<Int>(1)
    println("box: ${box.value}")
    sum(1)

    // 声明处型变（declaration-site variance）与类型投影（type projections）
    var strRooa: Rooa<String> = Rooa("a")
    var anyRooa: Rooa<Any> = Rooa<Any>("b")
    anyRooa =  strRooa  // 形变，可以赋值
    println(anyRooa.foo())

    var strRoob: Roob<String> = Roob("a")
    var anyRoob: Roob<Any> = Roob<Any>("b")
    strRoob = anyRoob   // 注意赋值顺序
 

    //使用类    
    val a1: A<*> = A(12, "String", Apple("苹果"))
    val a2: A<Any?> = A(12, "String", Apple("苹果"))   //和a1是一样的
    val apple = a1.t3    //参数类型为Any
    println(apple)
    val apple2 = apple as Apple   //强转成Apple类
    println(apple2.name)
    //使用数组
    val l:ArrayList<*> = arrayListOf("String",1,1.2f,Apple("苹果"))
    for (item in l){
        println(item)
    }

    // 枚举类型
    printAllValues<RGB>()
}

// class
class Box<T>(var t: T) {
    var value = t
    fun foo(): T {
        return t
    }
}

// function
fun <T> sum(t: T): T {
    return t
}

// 定义一个支持协变的类
class Rooa<out T>(val t: T) {
    fun foo(): T {
        return t
    }
}

// 定义一个支持逆变的类
class Roob<in T>(t: T) {
    fun foo(t: T): Unit {
        println("${t}")
    }
}

class A<T>(val t: T, val t2 : T, val t3 : T)
class Apple(var name : String)

enum class RGB {RED, GREEN, BLUE}
inline fun <reified T : Enum<T>> printAllValues() {
    println(enumValues<T>().joinToString())
}