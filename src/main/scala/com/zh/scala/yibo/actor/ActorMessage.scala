package com.zh.scala.yibo.actor

/**
  * 样本类，保存所有的消息
  */
object ActorMessage {

}

// worker --> master 注册节点
case class RegisterWorker(val id: String, val workerHost: String, val memory: String, val cores: String)

// worker  --> master 发送心跳信号
case class HeartBeat(val workid: String)

// master --> master 检查超时节点
case class CheckOfTimeOutWorker()

// master --> worker 注册完成通知
case class RegisteredWorker(val workerHost: String)

// worker --> worker 提醒自己发送心跳信号
case class SendHeartBeat()