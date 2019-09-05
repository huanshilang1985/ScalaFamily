package com.zh.scala.yibo.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}


/**
  * Actor 实例
  *
  * 2019/5/29 17:41
  */
class HelloActor extends Actor {

  override def receive: Receive = {
    case "Hello" => println("Hello Receive")
    case _ => println("aaaa")
  }

}

object Demo1 extends App {

  //1. 新建一个ActorSystem
  val system:ActorSystem = ActorSystem("HelloSystem")
  //2. 构造函数
  var helloActor:ActorRef =system.actorOf(Props[HelloActor], name="helloactor")
  //3. 发消息
  helloActor ! "Hello"
  helloActor ! "Hello message"

}
