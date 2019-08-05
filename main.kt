package main

fun main(args: Array<String>) {
    println("一行字符串")
    var text = """
    多行字符串
    多行字符串
    """
    println(text)

    var text2 = """
    |第一行
    |第二行
    |第三行
    """.trimMargin()
    println(text2)   // 删除前置空格
    println("test2: $text2, len: ${text2.length}")    // 字符串模板

    var bl = if (1>2) 1 else 2
    println(bl)

    // 数组 {1, 2, 3}
    var arr = Array(3, { i -> i + 1 })
    for (i in arr) {
        print("$i ")
    }

    // 循环
    var arr2 = arrayOf(1, 2, 3)
    for (i in arr2.indices) {
        print("${arr2[i]} ")
    }
    for ((index, value) in arr2.withIndex()) {
        print("$index->$value ")
    }

}

// >>>>> 从标签处返回
fun foo(ints: IntArray) {
    ints.forEach {
        if (it == 1) return // 从foo返回
        print(it)
    }
}
fun foo1(ints: IntArray) {
    ints.forEach lit@ {
        if (it == 1) return@lit // 从lit@返回
        print(it)
    }
}
fun foo2(ints: IntArray) {
    ints.forEach {
        if (it == 0) return@forEach // 从forEach返回
        print(it)
    }
}
// <<<<<