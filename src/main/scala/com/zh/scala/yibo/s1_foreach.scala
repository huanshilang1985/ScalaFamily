package com.zh.scala.yibo

/**
  * foreach的几种写法
  *
  * object 对象就类似于java中的static
  * scala 是没有 static的
  *
  * 在object里面，所有的内容都是静态的
  *
  * 2019/5/17 17:14
  */
object s1_foreach {

  def main(args: Array[String]): Unit = {
    val list: List[String] = List("Mary", "Tom", "Andy")

    /**
      * <- 表示scala的提取符， 把list中的每一个元素，赋值给s
      */
    println("-----for循环的第一种写法----")
    for (s <- list) println(s)

    /**
      * 打印长度大于3的名字
      */
    println("-----for循环的第二种写法----")
    for {s <- list
         if (s.length > 3)
    }
      println(s)

    /**
      * 对第二种写法，进一步简化，打印小于等于3的名字
      */
    println("-----for循环的第三种写法----")
    for (s <- list if s.length <= 3) println(s)

    /**
      * 1、把list中所有元素，都变成大写
      * 2、返回一个新的集合, yield
      **/
    println("-----for循环的第四种写法----")
    var newList: List[String] = for {s <- list
                                     s1 = s.toUpperCase()
    } yield (s1)
    for (s <- newList) println(s)


    /**
      * 自增, 注意 scala中 没有 i++
      */
    println("--------while循环--------------")
    //定义循环变量
    var i: Int = 0
    while (i < list.length) {
      println(list(i))
      i += 1
    }

    println("--------do while循环--------------")
    //定义一个循环变量
    var j: Int = 0
    do {
      println(list(j))
      j += 1
    } while (j < list.length)


    println("--------for each 循环--------------")
    /*
    * foreach scala里面有 spark里面
    * 还有另外一个循环方法map
    * foreach没有返回值 map有返回值
    *
    * foreach 是list的一个方法，我们把一个函数，传入了foreach
    * */
    list.foreach(println)



  }

}
