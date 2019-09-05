package com.zh.scala.yibo.actor

import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Worker类
  */
class Worker extends Actor {
  //Worker端持有Master端的引用（代理对象）
  //因为worker会给Master发送信息，所以才要这个对象
  var master: ActorSelection = null

  //生成一个UUID，作为Worker的标识  alt+enter
  val id: String = UUID.randomUUID().toString

  //构造方法执行完执行一次
  override def preStart(): Unit = {

    //Worker向MasterActorSystem发送建立连接请求
    master = context.system.actorSelection("akka.tcp://MasterActorSystem@localhost:8888/user/Master")

    //1. Worker向Master发送注册消息
    master ! RegisterWorker(id, "localhost", "10240", "8")

  }

  //该方法会被反复执行，用于接收消息，通过case class模式匹配接收消息
  override def receive: Receive = {

    //2. Master向Worker的反馈信息
    case RegisteredWorker(masterUrl) => {
      /**
        * 3. 启动定时任务，向Master发送心跳
        * schedule定时任务，参数1：等待几秒；参数2：每几秒触发一次；参数3：发给谁；参数4:发送信息
        * 要引入 import scala.concurrent.ExecutionContext.Implicits.global
        */
      context.system.scheduler.schedule(0 millis, 5000 millis, self, SendHeartBeat)
    }

    // 4. 发送心跳信息
    case SendHeartBeat => {
      println("worker send heartbeat")
      master ! HeartBeat(id)
    }
  }
}

object Worker extends App {
  val clientPort: Int = 8891

  //创建WorkerActorSystem的必要参数
  val configStr: String =
    s"""
       |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.port = $clientPort
       """.stripMargin

  val config: Config = ConfigFactory.parseString(configStr)

  val actorSystem: ActorSystem = ActorSystem("WorkerActorSystem", config)

  //启动Actor，Master会被实例化，生命周期方法会被调用
  actorSystem.actorOf(Props[Worker], "Worker")
}
