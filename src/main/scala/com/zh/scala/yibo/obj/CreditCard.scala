package com.zh.scala.yibo.obj

/**
  * 实现单例模式
  * 2019/5/22 21:44
  *
  */
object CreditCard {

  //定义一个变量来保存卡号
  private[this] var creditCardNumber : Long = 0

  //定义函数来生成卡号
  def generateNum():Long = {
    creditCardNumber += 1  //每次调用自增
    creditCardNumber     //返回值
  }

  def main(args: Array[String]): Unit = {
    println(CreditCard.generateNum())
    println(CreditCard.generateNum())
    println(CreditCard.generateNum())
    println(CreditCard.generateNum())
  }

}
