package com.zh.scala.yibo.obj

/**
  * 定义Student4的apply方法
  * 2019/5/22 21:24
  */
class o4_Student(var stuName: String)

object o4_Student {

  //定义apply方法，必须写在伴生对象中
  def apply(name: String): o4_Student = {
    println("调用了apply方法")
    new o4_Student(name)
  }

  def main(args: Array[String]): Unit = {
    // 通过主构造器来创建学生对象
    var s1: o4_Student = new o4_Student("Tom")
    println(s1.stuName)

    //通过apply方法来创建学生对象，省略new关键字
    var s2: o4_Student = o4_Student("Andy")
    println(s2.stuName)

  }

}