# Reference
1. [Kotlin for Android Developers][1] / [Kotlin for android Developers(中文翻译)][2]
2. [Kotlin Reference][3] / [Kotlin Reference(中文)][4]

# About Kotlin
> Kotlin，它是JetBrains开发的基于JVM的语言。JetBrains因为创造了一个强大的Java开发IDE被大家所熟知。Android Studio，
> 官方的Android IDE，就是基于Intellij，作为一个该平台的插件。Kotlin是使用Java开发者的思维被创建的，Intellij作为它主要的开发IDE。

### 优势： 
- 不影响性能
- 100%兼容Java
- 简洁、更具表达性（如 对lambda语法支持、运用）
- 安全：在编译时即处理了空（null）安全，这个后续细讲
- 函数式：Kotlin中加入了函数式编程的概念，这也进一步优化了代码的简洁性和可读性。
- 高度互操作性：Kotlin与Java间可以完美的进行协作，甚至可以在一个项目中使用Kotlin和Java两种语言混合编程。


  
# Setup
  Thanks [Create your first Android project using Kotlin ][5]
  
# Lesson 1

## Feature
### 1. 告别findViewById
```java
//给一个id为xMessage的TextView设置内容
xMessage.text = "Hello Kotlin!" //xMessage即为xml中对应id的一个实例（个人习惯以x开头，便于区分）
```
### 2. 类、属性、方法
```java 
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
     * = "$name , $age"  : 指定了一个默认值。这意味着改参数在你调用的时候可以传入或者不传，这样可以避免你需要的重载函数：
     */
    fun print(message: String = "$name , $age") {
        Log.e("Person", "message = $message") // 可以看到特殊字符$的使用，让我们在拼接字符串时变得更为简单
    }
}
```
类的使用:
```java
  var person = Person("wiky",23) //无需使用关键字 new
  // person.name = "wiky"
  // person.age = -1
```


  [1]: https://leanpub.com/kotlin-for-android-developers
  [2]: https://www.gitbook.com/book/wangjiegulu/kotlin-for-android-developers-zh/details
  [3]: http://kotlinlang.org/docs/reference/
  [4]: https://huanglizhuo.gitbooks.io/kotlin-in-chinese/content/ClassesAndObjects/Classes-and-Inheritance.html
  [5]: http://antonioleiva.com/create-first-android-project-kotlin/
