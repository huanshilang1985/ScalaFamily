package com.zh.scala.yibo.obj

/**
  * 样本类 case class
  *
  * 样本类的作用：
  * 1. 支持模式匹配 instanceof
  * 2. 定义SparkSQL中的schema，表结构
  * 2019/5/23 23:22
  */
object f3_caseClass {

  def main(args: Array[String]): Unit = {
    var aCar: f3_Vehicle = new f3_Car("福特")
    aCar match {
      case f3_Car(name) => println("汽车 " + name)
      case f3_Bike(name) => println("自行车 " + name)
      case _ => println("其他")
    }
  }

}

/**
  * 定义交通工具 父类
  */
class f3_Vehicle

/**
  * 定义小汽车 子类
  */
case class f3_Car(name: String) extends f3_Vehicle

/**
  * 定义自行车 子类
  */
case class f3_Bike(name: String) extends f3_Vehicle





