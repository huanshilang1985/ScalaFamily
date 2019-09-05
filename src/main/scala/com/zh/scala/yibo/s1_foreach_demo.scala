package com.zh.scala.yibo

import scala.collection.mutable.ArrayBuffer
import util.control.Breaks._
import scala.math._

/**
  * foreach应用样例
  * 2019/5/17 17:42
  */
object s1_foreach_demo {

  def main(args: Array[String]): Unit = {
    //    sushu
    sort
  }

  /**
    * 判断 101-200之间有多少个素数
    *
    * 判定素数的方法：* x % 2 --- x % sqrt(根号) x
    * 当都不能被整除的时候，就是素数
    *
    * 16
    * sqrt(16)=4
    * 2 3 4
    * 16%2 == 0 ?
    *
    * 编程思路：
    * 两层循环：
    * 第一层 101-200
    * 第二层 2 sqrt第一层
    *
    */
  def sushu: Unit = {
    println("-----------循环嵌套-------------")
    var count: Int = 0 //保存结果
    var buff: ArrayBuffer[Int] = ArrayBuffer()
    var index_outer: Int = 0 //外层循环变量
    var index_inner: Int = 0 //内层循环变量

    for (index_outer <- 101 until 200) {
      var b: Boolean = false //表示是否能被整除
      index_inner = 2
      breakable {
        while (index_inner <= sqrt(index_outer)) { //如果内变量小于等于 外变量的根号值，就循环
          if (index_outer % index_inner == 0) { //如果内变量更够被外变量整除
            b = true
            break //break要写在breakable方法块里
          }
          index_inner += 1
        }
      }
      //总数加1
      if (!b) {
        count += 1
        buff += index_outer
      }
    }
    println("个数为： " + count)
    for (s <- buff) println(s)
  }

  /**
    * 题目：冒泡排序
    * https://www.cnblogs.com/morethink/p/8419151.html#%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F
    *
    * 算法分析：
    * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
    * 2、对每一对相邻元素都做上述工作，循环完第一次后，最后的元素，就是最大的元素。
    * 3、针对剩下的元素，重复上面工作（除了最后一个元素）
    *
    * 程序分析：
    * 1、两层循环
    * 2、外层循环控制比较的次数
    * 3、内层循环控制到达的位置，就是 结束比较 的位置
    */
  def sort: Unit = {
    println("-----------冒泡排序-------------")
    var a: Array[Int] = Array(12, 3, 6, 2, 4, 7, 9, 5, 30, 1)
    println("-----------排序前-------------")
    a.foreach(println)

    for (i <- 0 until a.length - 1) {
      for (j <- 0 until a.length - i - 1) {
        if (a(j) > a(j + 1)) {
          // 交换
          var tmp: Int = a(j)
          a(j) = a(j + 1)
          a(j + 1) = tmp
        }
      }
    }
    println("-----------排序后-------------")
    a.foreach(println)
  }

}
