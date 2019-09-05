package com.zh.scala.yibo

import java.io.{File, FileInputStream, PrintWriter}

import scala.io.BufferedSource
import scala.io.Source._

/**
  * io读取文件
  */
object s3_io {


  def main(args: Array[String]): Unit = {
    var source: BufferedSource = fromFile("H:\\tmp_files\\student.txt")


  }

  /**
    * 1. 将整个文件作为一个字符串输出
    */
  def io_mkString(source: BufferedSource): Unit = {
    println("-----mkString------")
    println(source.mkString)
  }

  /**
    * 2. 将文件的每一行读入并输出
    */
  def io_lines(source: BufferedSource): Unit = {
    println("-----lines-------")
    var lines: Iterator[String] = source.getLines();
    lines.foreach(println)
  }

  /**
    * 3.读取每一个字符
    */
  def io_char(source: BufferedSource): Unit = {
    println("-------char-----")
    for (c <- source) println(c)
  }

  /**
    * 读取URL
    */
  def io_url(): Unit = {
    println("----------URL----------")
    var source: BufferedSource = fromURL("http://www.baidu.com", "UTF-8")
    println(source.mkString)
  }

  /**
    * 读取二进制文件
    * 注意：Scala并不支持直接读取二进制文件
    * 通过调用Java的InputStream来实现
    */
  def io_Bytes: Unit = {
    println("-----Read Bytes------")
    var file: File = new File("H:\\tmp_files\\hudson.war")
    // 构造一个inputStream
    var in: FileInputStream = new FileInputStream(file)
    // 构造一个buffer
    var buffer: Array[Byte] = new Array[Byte](file.length().toInt)
    // 读取
    in.read(buffer)
    println(buffer.length)
    // 关闭
    in.close()
  }

  /**
    * 写入文件  0到10
    */
  def ip_writer: Unit = {
    println("--------Write File---------")
    var out: PrintWriter = new PrintWriter("H:\\tmp_files\\insert.txt")
    for (i <- 0 until 10) out.println(i)
    out.close()
  }

}
