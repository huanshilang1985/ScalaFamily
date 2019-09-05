package com.zh.scala.yibo.obj

/**
  * 主构造器：和类的声明在一起，并且一个类只能有一个主构造器
  * 辅助构造器：一个类可以有多个辅助构造器，通过this来实现
  * 2019/5/20 23:04
  */
class o3_Student(var stuName: String, var age: Int) { //这行就是主构造器

  //辅助构造器，就是一个函数，只不过这个函数的名字就叫this
  def this(age: Int) {
    this("no name", age)
  }

  override def toString: String = stuName + "\t" + age
}

object o3_Student {

  def main(args: Array[String]): Unit = {
    var s1: o3_Student = new o3_Student("zhangsan", 18)
    var s2: o3_Student = new o3_Student(20)
    println("主构造器：" + s1.toString)
    println("辅助构造器：" + s2.toString)
  }
}
