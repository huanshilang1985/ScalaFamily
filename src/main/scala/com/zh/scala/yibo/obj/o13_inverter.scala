package com.zh.scala.yibo.obj

/**
  *
  * 2019/5/27 22:57
  */
object o13_inverter {
  def main(args: Array[String]): Unit = {
    //定义一个鸟吃东西的对象
    var c1: o13_EatSomething[o13_Bird] = new o13_EatSomething[o13_Bird](new o13_Bird)
    //定义一个东西吃东西的对象
    var c2 : o13_EatSomething[o13_Sparrow] = c1

    /**
      *  问题1：能否把c1 赋给 c2  ？  逆变
      *  o13_EatSomething[T](t:T)
      *   var c2 : o13_EatSomething[o13_Sparrow] = c1  报错
      *  因为o13_EatSomething[o13_Sparrow] 并没有继承 o13_EatSomething[o13_Bird]
      *
      *  o13_EatSomething[-T](t:T) 报错消失，正常使用，这就是逆变
      */
  }
}

class o13_Animal

class o13_Bird extends o13_Animal

class o13_Sparrow extends o13_Bird

/**
  * 吃东西的类，在
  */
class o13_EatSomething[-T](t:T)
