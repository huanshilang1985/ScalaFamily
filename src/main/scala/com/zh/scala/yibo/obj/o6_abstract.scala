package com.zh.scala.yibo.obj

/**
  * 抽象类：只能用于继承的类，可以包含抽象方法
  * 2019/5/22 21:53
  */
object Demo2 {

  def main(args: Array[String]): Unit = {
    var v1 :Vehicle = new Car
    println(v1.checkType())

    var v2:Vehicle = new Bike
    println(v2.checkType())
  }

}

//父类：交通工具类
abstract class Vehicle{

  //抽象方法：没有实现的方法
  def checkType():String
}

//子类：汽车
class Car extends Vehicle {
  override def checkType(): String = "I am a car"
}

//子类：自行车
class Bike extends Vehicle {
  override def checkType(): String = "I am a bike "
}
