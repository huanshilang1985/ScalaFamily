package com.zh.scala.yibo.fun

/**
  * 对比flatMap与map
  * 2019/5/23 22:11
  */
object f1_flatMap {

  def main(args: Array[String]): Unit = {
    flatMap1()
    map1()
  }

  /**
    * .flatMap 执行分析：
    * 1 List(1*2) = List(2)
    * 2 List(2*2) = List(4)
    * 3 List('a','b')
    *
    * List(List(2), List(4), List('a','b'))
    * List(2, 4, a, b)
    */
  def flatMap1(): Unit = {
    val li: List[Int] = List(1, 2, 3)
    val res: List[Any] = li.flatMap(x => x match {
      case 3 => List('a', 'b')
      case _ => List(x * 2)
    })
    println(res)
  }

  /**
    * .map 执行过程
    * 1  2  ---> List(2,2,3)
    * 2  4  ---> List(2,4,3)
    * 3  List('a','b') --->List(2,4,List('a','b'))
    *
    * List(2,4,List('a','b'))
    */
  def map1(): Unit = {
    var li: List[Int] = List(1, 2, 3)
    val list: List[Any] = li.map(x => x match {
      case 3 => List('a', 'b')
      case _ => x * 2
    })
    println(list)
  }

}
