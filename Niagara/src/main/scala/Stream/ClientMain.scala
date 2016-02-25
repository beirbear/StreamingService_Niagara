package Stream

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

/**
  * Created by beir on 2/24/16.
  */
object ClientMain extends App {

  val system = ActorSystem("ClientSystem")

  import StreamEngine.StreamMain
  val streamRef = system.actorOf(Props[StreamMain], name = "StreamMain")

  import RESTServices.ServiceMain
  val serviceRef = system.actorOf(Props(new ServiceMain(streamRef)), name = "ServiceMain")
  // val serviceRef = system.actorOf(Props[ServiceMain], name = "ServiceMain")

  // serviceRef
}
