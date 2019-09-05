package com.zh.scala.yibo.actor

/**
  * 保存worker的基本信息
  */
class WorkerInfo(val id: String, val workerHost: String, val memory: String, val cores: String) {

  var lastHeardBeat : Long = System.currentTimeMillis();

  override def toString: String = s"WorkerInfo($id, $workerHost, $memory, $cores)"
}
