package com.zh.scala.yibo.obj

/**
  * 协变：表示在类型参数前面加上 + ，泛型变量的值，可以是本身类型或者其子类型
  * 逆变：表示在类型参数前面加上 - ，泛型变量的值，可以是本身类型或者其父类型
  * 2019/5/27 22:44
  */
object o12_covariant {

  def main(args: Array[String]): Unit = {
    //定义一个鸟吃东西的对象
    var c1: o12_EatSomething[o12_Bird] = new o12_EatSomething[o12_Bird](new o12_Bird)
    //定义一个东西吃东西的对象
    var c2 : o12_EatSomething[o12_Animal] = c1

    /**
      *  问题1：能否把c1 赋给 c2  ？  协变
      *  o12_EatSomething[T](t:T)
      *  var c2 : o12_EatSomething[o12_Animal] = c1  报错
      *  因为o12_EatSomething[o12_Bird] 并没有继承 o12_EatSomething[o12_Animal]
      *
      *  o12_EatSomething[+T](t:T) 报错消失，正常使用，这就是协变
      */
  }
}


class o12_Animal

class o12_Bird extends o12_Animal

class o12_Sparrow extends o12_Bird

/**
  * 吃东西的类，在
  */
class o12_EatSomething[+T](t:T)