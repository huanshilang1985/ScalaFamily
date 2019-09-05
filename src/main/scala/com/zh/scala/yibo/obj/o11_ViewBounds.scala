package com.zh.scala.yibo.obj

/**
  * 就是上界和下界的扩展
  * 除了可以接收上界和下界规定的类型以外，还可以接收能够通过隐式转换过去的类型
  *
  * 2019/5/27 22:23
  */
object o11_ViewBounds {

  def main(args: Array[String]): Unit = {
    addTwoString("aaaa", "bbbbb")
    addTwoString(111,222)   //这样int也可以使用函数了
  }



  /**
    * 函数：限定两个String类型的相加
    */
  def addTwoString[T <% String](x:T,y:T):Unit = println(x + "****" + y)

  /**
    * 定义隐式函数，int自动转String
    */
  implicit def int2String(n:Int):String = n.toString

}



