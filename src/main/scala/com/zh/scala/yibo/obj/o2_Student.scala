package com.zh.scala.yibo.obj

import scala.collection.mutable.ArrayBuffer

/**
  * 内部类
  * 定义学生类，同时要保存学成的成绩信息
  * 2019/5/20 22:45
  */
class o2_Student {

  private var stuName: String = "Tom"
  private var stuAge: Int = 20

  //数组，保存学生的课程成绩信息
  private var courseList:ArrayBuffer[Course] = new ArrayBuffer[Course]()

  /**
    * 函数：用于添加学生课程成绩
    */
  def addNewCourse(cname:String,grade:Int): Unit = {
    var c:Course = new Course(cname, grade)
    courseList += c
  }

  //内部类，课程类
  class Course(var courseName: String, var grade: Int) {
    override def toString: String = courseName +"\t" + grade
  }

}

object o2_Student {

  def main(args: Array[String]): Unit = {
    var s:o2_Student = new o2_Student
    s.addNewCourse("Chinese", 70)
    s.addNewCourse("Math", 80)
    s.addNewCourse("English", 60)

    println(s.stuName + "\t" + s.stuAge)
    println("----课程信息-----")
    for(c <- s.courseList) println(c.toString)
  }
}