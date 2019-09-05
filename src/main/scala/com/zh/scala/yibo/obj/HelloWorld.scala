package com.zh.scala.yibo.obj

/**
  * 继承App，等于有默认的main方法
  * 2019/5/22 21:48
  */
object HelloWorld extends App{

  println("Hello World")

  //也可以直接获取args参数的
  if(args.length > 0){
    println("有参数")
  } else {
    println("没参数")
  }

}
