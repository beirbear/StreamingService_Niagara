package Stream.StreamEngine

import akka.actor.Actor

class StreamMain extends Actor {
  import SharedObjects.Common.ActionMessage
  def receive = {
    case ActionMessage.Stream.RunLocal =>
      println("Run Local Service")
      runSampleDataStream()
    case _ => println("StreamMain any message")
  }

  // Internal Function --------------------------------------
  def runSampleDataStream(): Unit = {
    import Stream.StreamEngine.DataPlugin.DummySource
    val dataSource = new DummySource()
    val data = dataSource.getData(100)
    println(data(0).mkString(", "))
  }
}
