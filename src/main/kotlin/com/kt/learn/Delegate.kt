package com.kt.learn

import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun doDelegate(): Unit {
    val b = DelegateBaseImpl(1)
    var map = mutableMapOf(
        "aname" to "avalue",
        "bname" to "bvalue"
    )
    DelegateDerived(b, map).print()
    var a = DelegateDerived(b, map)
    println(a.p)
    a.p = "赋值代理属性"
    println(a.p)
    a.name = "first"
    a.name = "second"
    println("${a.aname}")
    println("${a.bname}")
}

// class delegate
interface DelegateBase {
    fun print()
}

private class DelegateBaseImpl(val x: Int): DelegateBase {
    override fun print(): Unit {
        print(x)
    }
}

private class DelegateDerived(b: DelegateBase, var map: MutableMap<String, String>) : DelegateBase by b {
    var p: String by PropertyDelegate()

    // 可观察属性Observable
    var name: String by Delegates.observable("初始值") {
        prop, old, new ->
        println("$prop old: $old -> new: $new")
    }

    // 属性保存到映射中
    var aname: String by map
    var bname: String by map

    // 延时初始化，注意val
    val lazyValue: String by lazy {
        println("computed!")     // 第一次调用输出，第二次调用不执行
        "Hello"
    }
}

// property delegate
// val/var <属性名>: <类型> by <表达式>
private class PropertyDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 这里委托了 ${property.name} 属性"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}

// 提供委托
// class ResourceDelegate<T> : ReadOnlyProperty<MyUI, T> {
//     override fun getValue(thisRef: MyUI, property: KProperty<*>): T { 
//         return T()
//     }
// }

// class ResourceLoader<T>(id: ResourceID<T>) {
//     operator fun provideDelegate(
//             thisRef: MyUI,
//             prop: KProperty<*>
//     ): ReadOnlyProperty<MyUI, T> {
//         checkProperty(thisRef, prop.name)
//         // 创建委托
//         return ResourceDelegate<T>()
//     }

//     private fun checkProperty(thisRef: MyUI, name: String) {
//         println("$thisRef -> $name")
//     }
// }

// class MyUI {
//     fun <T> bindResource(id: ResourceID<T>): ResourceLoader<T> {
//         return ResourceLoader<T>(id)
//     }

//     val image by bindResource(ResourceID.image_id)
//     val text by bindResource(ResourceID.text_id)
// }

// class ResourceID<T> {
//     companion object {
//         val image_id: T
//         val text_id: T
//     } 
// }