package com.zh.scala.yibo.obj

/**
  * trait 特质，类似于接口，多重继承
  * 定义两个父类，就是两个trait
  *
  * 2019/5/22 22:00
  */
object Demo3_trait {

  def main(args: Array[String]): Unit = {
    var s1: Student = new Student(1, "Tom")
    println(s1.id + "\t" + s1.name)
    println(s1.getActionName())
  }

}

/**
  * 父类：人
  */
trait Human {
  val id: Int
  val name: String
}

/**
  * 父类：动作
  */
trait Action {
  def getActionName(): String
}

/**
  * 子类：学生
  * 实现了多重继承
  */
class Student(val id: Int, val name: String) extends Human with Action {

  override def getActionName(): String = "Action is running"

}


