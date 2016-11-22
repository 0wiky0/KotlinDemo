package com.wiky.kotlindemo

import android.util.Log

/**
 * 默认任何类都是基础继承自Any（与java中的Object类似）。
 * 所有的类默认都是不可继承的（final），所以我们只能继承那些明确声明open或者abstract的类：
 * open class Animal(name: String)
 * class Person(name: String, surname: String) : Animal(name)
 *
 * Created by wiky on 2016/11/22.
 */
class Person {
    /**
     * 构造器
     * 详情：https://huanglizhuo.gitbooks.io/kotlin-in-chinese/content/ClassesAndObjects/Classes-and-Inheritance.html
     */
    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    /**
     * 属性（可变：var 、 不可变：val）
     * 可以直接通过Person对象进行调用，如：person.name （Kotlin已经帮我们处理好了setter()/getter()方法）
     */
    var name: String = ""

    /**
     * 自定义处理get()与set()
     * field : 如果需要在getter和setter中访问这个属性自身的值，我们需要利用field这个预留字段来访问，它会被编译器找到正在使用的并自动创建。
     */
    var age: Int = -1
        get() {
            Log.e("Person", "get field = " + field)
            if (field < 0)
                return 0
            return field
        } set(value) {
        Log.e("Person", "set value = " + value)
        if (value < 0)
            field = 0
        else
            field = value

    }


    /**
     * 方法（函数）print ,关键字 fun
     *
     * @param message （参数）打印内容，类型String
     * = name + ", " + age  : 指定了一个默认值。这意味着改参数在你调用的时候可以传入或者不传，这样可以避免你需要的重载函数：
     */
    fun print(message: String = name + ", " + age) {
        Log.e("Person", message)
    }
}