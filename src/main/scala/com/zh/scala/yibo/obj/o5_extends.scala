package com.zh.scala.yibo.obj

/**
  * extends继承
  *
  * 父类：Person 人
  * 子类：Employee 员工
  *
  * 2019/5/22 21:33
  */
object Demo1 extends App {
  //父类
  var p1: Person = new Person("Tom", 20)
  println(p1.name + "\t" + p1.age)
  println(p1.sayHello())

  //子类对象
  var p2: Person = new Employee("Mike", 25, 1000)
  println(p2.sayHello())

  //匿名子类
  var p3: Person = new Person("Mary", 25) {
    override def sayHello(): String = "匿名子类的sayHello"
  }
  println(p3.sayHello())

}

/**
  * 定义父类
  */
class Person(val name: String, val age: Int) {
  //定义父类函数
  def sayHello(): String = "Hello " + name + " and the age is " + age
}

/**
  * 定义子类
  * 子类属性要覆盖父类的话，需要使用override关键字
  */
class Employee(override val name: String, override val age: Int, val slalry: Int) extends Person(name, age) {

  // 重写父类的函数
  override def sayHello(): String = "子类中的sayHello"
}
