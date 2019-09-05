package com.zh.scala.yibo.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  * 建立两个Actor相互传递信息
  *
  * 定义消息：样本类，区分消息的不同
  *
  * 2019/5/29 18:02
  */
object Actor2Actor extends App {

  var system: ActorSystem = ActorSystem("PingPongSystem")
  val pong: ActorRef = system.actorOf(Props[Pong], name = "pong")
  val ping: ActorRef = system.actorOf(Props(new Ping(pong)), name = "ping")

}

//消息定义
case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage

class Ping(pong: ActorRef) extends Actor {

  var count:Int = 0
  def incrementAndPring {count += 1; println(" Ping ") }

  override def receive: Receive = {
    case StartMessage =>
      incrementAndPring
      pong ! PingMessage
    case PongMessage =>
      if (count > 9){
        pong ! StopMessage
      } else {
        incrementAndPring
        pong ! PingMessage

      }
  }
}

class Pong extends Actor {
  override def receive: Receive = {
    case PingMessage =>
      println("pong")
      // 给 ping 回复消息
      sender ! PongMessage
    case StopMessage =>
      println("pong Stop")
      context.stop(self)
  }
}
