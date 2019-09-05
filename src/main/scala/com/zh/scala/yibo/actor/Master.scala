package com.zh.scala.yibo.actor

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}

import scala.collection.mutable
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global


/**
  * Worker类
  */
class Master extends Actor {

  //保存WorkerID和Work信息的map
  val idToWorder: mutable.HashMap[String, WorkerInfo] = new mutable.HashMap[String, WorkerInfo]

  //保存所有Worker信息的Set
  val workers: mutable.HashSet[WorkerInfo] = new mutable.HashSet[WorkerInfo]

  //Worker超时时间
  val WORKER_TIMEOUT: Int = 10 * 1000

  //构造方法执行完执行一次
  override def preStart(): Unit = {
    //启动定时器，定时执行
    //设置在5毫秒之后，间隔10秒，给自己发一个CheckOfTimeOutWorker
    context.system.scheduler.schedule(5 millis, WORKER_TIMEOUT millis, self, CheckOfTimeOutWorker)

  }

  override def receive: Receive = {

    //1. Worker向Master发送的注册消息
    case RegisterWorker(id, workerHost, memory, cores) => {
      if (!idToWorder.contains(id)) { //要确认是第一次注册
        val worker:WorkerInfo = new WorkerInfo(id, workerHost, memory, cores)
        workers.add(worker)  //更新worker列表
        idToWorder(id) = worker
        println("new register worker: " + worker)   //默认会调用worker的toString方法
        //2. 回复信息
        sender ! RegisteredWorker(worker.id)
      }
    }

    //4. Worker向Master发送的心跳消息
    case HeartBeat(workerId) => {
      val workderInfo: WorkerInfo = idToWorder(workerId)
      println("get heartbeat message from: " + workderInfo)
      workderInfo.lastHeardBeat = System.currentTimeMillis() //更新心跳时间
    }

    // 5. Master检查超时worker
    case CheckOfTimeOutWorker => {
      val currentTime: Long = System.currentTimeMillis()
      //遍历worker，提取超时的worker
      var toRemove: Array[WorkerInfo] = workers.filter(w => currentTime - w.lastHeardBeat > WORKER_TIMEOUT).toArray
      for (worker <- toRemove) {
        workers -= worker
        idToWorder.remove(worker.id)
      }
      println("worker size: " + workers.size)
    }
  }
}

object Master extends App {
  val host: String = "localhost"
  val port: Int = 8888

  //创建ActorSystem的必要参数
  val configStr: String =
    s"""
       |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname = "$host"
       |akka.remote.netty.tcp.port = "$port"
       """.stripMargin

  val config: Config = ConfigFactory.parseString(configStr)

  //ActorSystem是单例的，用来创建Actor
  val actorSystem: ActorSystem = ActorSystem("MasterActorSystem", config)

  //启动Actor，Master会被实例化，生命周期方法会被调用
  actorSystem.actorOf(Props[Master], "Master")
}

