package com.zh.scala.yibo.fun

import scala.reflect.ClassTag

/**
  * 泛型函数
  * 2019/5/27 15:48
  */
object f3_generic {

  /**
    * 定义一个Int函数
    */
  def mkIntArray(elem:Int*):Array[Int] = Array[Int](elem:_*)

  /**
    * 定义一个String函数
    */
  def mkStringArray(elem:String*):Array[String] = Array[String](elem:_*)

  /**
    * 定义一个泛型函数
    * ClassTag：表示scala在运行时候的状态信息，这里表示调用时候的数据类型。（传什么类型是什么类型）
    * 只有有重复订单时候，都可以考虑用泛型
    * @tparam T 泛型类型
    * @return
    */
  def mkArray[T:ClassTag](elem:T*):Array[T] = Array[T](elem:_*)

  def main(args: Array[String]): Unit = {
    val array:Array[Any] = mkArray("abc", 111)
    array.map(println(_))
  }


}



