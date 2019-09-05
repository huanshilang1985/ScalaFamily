package com.zh.scala.yibo.obj

/**
  * 伴生对象，私有属性
  * 2019/5/20 21:54
  */
class o1_Student {

  //  private[this] var stuId:Int = 0
  private var stuId: Int = 0
  private var stuName: String = "Tom"
  private var age: Int = 20

  //age的get、set方法
  def getStuage(): Int = age

  def setStuage(age: Int) = this.age = age
}

/**
  * 注意：object和 class的名字可以不一样
  * 如果一样的话，这个object就叫做class的伴生对象
  */
object o1_Student {

  def main(args: Array[String]): Unit = {
    var s1: o1_Student = new o1_Student

    //访问get方法
    println(s1.stuName + "\t" + s1.getStuage())

    //访问set方法
    s1.stuId=1
    s1.setStuage(50)
    println(s1.stuName + "\t" + s1.getStuage())

    /**
      * 直接访问私有属性
      *
      * 为什么可以直接访问私有成员变量？s1.stuId
      * 1、当一个属性是private的时候，scala会自动为其生成对应的get、set方法，与变量名称一样
      * 2. 如果只希望生产get方法而不生产set方法的时候，可以定位常量
      * 3. 如果希望属性不能被外部访问，使用private[this]关键字
      */
    println(s1.stuId + "\t" + s1.stuName + "\t" + s1.age)
  }
}