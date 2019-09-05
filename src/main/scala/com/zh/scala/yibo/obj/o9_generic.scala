package com.zh.scala.yibo.obj

/**
  * 泛型类
  * 2019/5/23 23:31
  */
object o9_generic {

  def main(args: Array[String]): Unit = {
    var v1:GenericClass[Int] = new GenericClass[Int]
    v1.set(1000)
    println(v1.get())

    // 定义一个String类型
    var v2:GenericClass[String] = new GenericClass[String]
    v2.set("Hello")
    println(v2.get())
  }

}

/**
  * 操作一个整数
  */
class GenericClassInt {
  private var content :Int = 10
  def set(value :Int ):Unit = content = value
  def get() :Int = content
}

/**
  * 操作一个字符串
  */
class GenericClassString {
  private var content :String = ""
  def set(value :String ):Unit = content = value
  def get() :String = content
}

/**
  * 定义一个类，可以操作任何东西
  * 相当于 GenericClassInt + GenericClassString
  * @tparam T
  */
class GenericClass[T] {
  private var content : T = _ //注意：初始值用 _ 来表示
  def set(value :T ):Unit = content = value
  def get() :T = content

}
