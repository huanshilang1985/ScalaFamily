package com.zh.scala.yibo.fun

/**
  * 相当于Java中的switch case
  * 2019/5/23 22:51
  */
object f2_match {

  def main(args: Array[String]): Unit = {
    match1()
    match2()
    match3()
    match4()
  }

  /**
    * 1. 基础用法
    * 判断符号，输出对应的值
    */
  def match1(): Unit = {
    var chi: Char = '-'
    var sign: Int = 0
    chi match {
      case '+' => sign = 1
      case '-' => sign = -1
      case _ => sign = 0 //其他类型
    }
    println(sign)
  }

  /**
    * 2. Scala中的守卫
    * case _ if 匹配某种类型的所有值
    * 需求：匹配所有的数字
    */
  def match2(): Unit = {
    var ch2: Char = '6'
    var result: Int = -1
    ch2 match {
      case '+' => println("这是一个加号")
      case '-' => println("这是一个减号")
      //判断字符是否是数据，是的话转换成10进制
      case _ if Character.isDigit(ch2) => result = Character.digit(ch2, 10)
      case _ => println("其他")
    }
    println(result)
  }

  /**
    * 3. 在模式匹配中使用变量
    */
  def match3(): Unit = {
    var mystr: String = "Hello World"
    // 取字符串第7位，赋给模式匹配的变量
    mystr(7) match {
      case '+' => println("这是一个加号")
      case '-' => println("这是一个减号")
      // case 语句中使用的变量 ch 代表传入的字符
      case ch => println(ch)
    }
  }

  /**
    * 4. 匹配类型，相当于Java的 instance of
    *
    * Any : 表示任何类型，相当于Java中的Object
    * Unit：表示没有值，相当于void
    * Nothing：在函数抛出异常时，返回值就是Nothing。是Scala类层级中的最低端；他是任何其他类型的子类型
    * Null：所用引用类型的子类，值=null
    *
    * 特殊的类型：
    * Option: 表示一个值是可选的（有值或者无值）
    * Some：如果值存在，Option[T] 就是一个Some[T]
    * None: 如果值不存在，Option[T] 就是None
    *
    * scala> var myMap = Map("Andy"->90)
    * scala> myMap.get("Andy")       res0: Option[Int] = Some(90)
    * scala> myMap.get("Andy1231231231231")    res1: Option[Int] = None
    *
    * Nil 空的List
    */
  def match4(): Unit = {
    var v4: Any = 100
    v4 match {
      case z: Int => println("这是一个整数，值是 " + z)
      case s: String => println("这是一个字符串")
      case _ => println("这是其他类型")
    }
  }

  /**
    * 5. 匹配数组和列表
    */
  def match5(): Unit = {
    var myArray: Array[Int] = Array(1, 2, 3)
    myArray match {
      case Array(0) => println("数组中只有一个0")
      case Array(x, y) => println("数组中包含两个元素")
      case Array(x, y, z) => println("数组中包含三个元素")
      case Array(x, _*) => println("这是一个数组，包含多个元素")
    }

    var myList: List[Int] = List(1, 2, 3)
    myList match {
      case List(0) => println("列表中只有一个0")
      case List(x, y) => println("列表中包含两个元素，和是 " + (x + y))
      case List(x, y, z) => println("列表中包含三个元素，和是 " + (x + y + z))
      case List(x, _*) => println("这是一个列表，包含多个元素，和是 " + myList.sum)
    }
  }

}
