package com.zh.scala.yibo.obj

/**
  * 上界和下界：限制泛型的取值范围
  * T 类的继承关系 A --> B --> C --> D 箭头指向子类
  * 定义 T 的取值范围 D <: T <: B
  * T 的取值范围就是B C D
  *
  * 上下界的表示方法 <:
  *
  * 概念：
  * 上界 S <: T 规定了S的类型必须是T的子类或本身
  * 下界 U >: T 规定了U的类型必须是T的父类或本身
  *
  * 2019/5/27 15:58
  */
object o10_bound {

  def takeVehicle[T <: o10_Vehicle](v:T):Unit = v.drive

  def main(args: Array[String]): Unit = {
    var v:o10_Vehicle = new o10_Vehicle
    takeVehicle(v)
    takeVehicle(new o10_Bike)
  }

}

/**
  * 定义父类，交通工具
  */
class o10_Vehicle {
  def drive:Unit = println("Driving")
}

/**
  * 定义子类，小汽车
  */
class o10_Car extends o10_Vehicle {
  override def drive: Unit = println("Car Driving")
}

/**
  * 定义子类，自行车
  */
class o10_Bike extends o10_Vehicle {
  override def drive: Unit = println("Bike Driving")
}

