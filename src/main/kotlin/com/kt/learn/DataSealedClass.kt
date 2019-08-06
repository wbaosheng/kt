package com.kt.learn

data class User(val name: String, val age: Int)

fun dataSealedClass(): Unit {
    val jack = User("jack", 10)
    println(jack)

    println(eval(Sum(Const(4.0), Const(5.0))))
}

// 密封类用来表示受限的类继承结构：当一个值为有限几种的类型, 而不能有任何其他类型时。
// 在某种意义上，他们是枚举类的扩展：枚举类型的值集合 也是受限的，但每个枚举常量只存在一个实例，而密封类 的一个子类可以有可包含状态的多个实例。
// 声明一个密封类，使用 sealed 修饰类，密封类可以有子类，但是所有的子类都必须要内嵌在密封类中。
sealed class Expr

data class Const(val number: Double): Expr()
data class Sum(val e1: Expr, val e2: Expr): Expr()
object NotNumber : Expr()

fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotNumber -> Double.NaN
}