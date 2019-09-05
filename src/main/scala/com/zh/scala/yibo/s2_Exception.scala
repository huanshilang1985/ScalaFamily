package com.zh.scala.yibo

import java.io.FileNotFoundException

/**
  * Scala异常
  */
object s2_Exception {

  def main(args: Array[String]): Unit = {

  }

  /**
    * 1、采用 try catch finally 来捕获异常和处理异常
    * 试验一下，scala中文件读取
    *
    * 当没有抛出异常是：try --> finally
    *   打印：This is final
    * 当抛出异常时：try --> catch --> finally
    *   打印：File Not Found Exception
    *         This is finally
    */
  def exception1: Unit = {
    try {
      // try 代码块里面写 可能抛出异常的函数
      println("------------try catch finally------------------")
      var words: String = scala.io.Source.fromFile("H:\\tmp_files\\student123132123.txt").mkString
    } catch {
      case ex: FileNotFoundException => {
        println("File Not Found Exception")
      }
      case ex: IllegalArgumentException => {
        println("Illegal Argument Exception")
      }
      case _: Exception => {
        println("This is an Exception")
      }
    } finally {
      println("This is finally")
    }
  }

  /**
    * 如果一个函数返回值类型是nothing
    * 表示在函数执行的过程中，产生了异常
    * @return
    */
  def exception2 : String = {
    throw new Exception("Exception")
  }
}
