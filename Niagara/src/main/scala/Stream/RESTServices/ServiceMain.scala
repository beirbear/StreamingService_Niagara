package Stream.RESTServices

import SharedObjects.DataSource.HeaderStructure.{JsonSupport, DataSourceHeader, DataSource}
import akka.actor.{PoisonPill, ActorSystem, ActorRef, Actor}
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import spray.json._

import SharedObjects.DataSource._

class ServiceMain(streamRef: ActorRef) extends Actor with JsonSupport {
// class ServiceMain extends Actor {
  implicit val system = ActorSystem("RESTSystem")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  val route = path("general" / "dataSource"){
      get {
        val message = "GET: general/dataSource"
        complete {
          s"$message\n\n${DataSourceHeader.dataSource}"
        }
      } ~
      post {
        entity(as[DataSource]) { source =>
          val message = "POST: general/dataSource"
          val respond = s"DataSource was set from ${source.author}"
          DataSourceHeader.dataSource = source

          complete {
            s"$message\n$respond\n\n${DataSourceHeader.dataSource}"
          }
        }
      }
    } ~
    path("general" / "resources") {
      get {
        complete("GET: general/resources")
      }
    } ~
    path("general" / "status") {
      get {
        complete("GET: general/status")
      }
    } ~
    path("actions" / "run") {
      get {
        if (runDataStream()){
          complete("GET: action/run (RUNNING)")
        }
        else
          complete("GET: action/run (ERROR)")
      }
    } ~
  path("actions" / "kill") {
    get {
      killApplication()
      complete("GET: action/kill")  // You will not see this message.
    }
  }

  val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

  // Message Box ------------------------------------------------------------------
  def receive = {
    case _ => throw new Exception("Case object error in ServiceMain.scala")
  }

  // Internal Function ------------------------------------------------------------
  def killApplication(): Unit = {
    println("Bad Termination")
    System.exit(0)
  }

  def runDataStream(): Boolean = {
    import SharedObjects.DataSource.Services.StreamCheck
    if (StreamCheck.isReadyForDataStream()) {
      if (DataSourceHeader.dataSource.dataSourceAddress == "localTest") {
        import SharedObjects.Common.ActionMessage
        streamRef ! ActionMessage.Stream.RunLocal

        true
      } else {
        // Leave some space to check for other things
        false
      }
    }
    else
      false
  }

  // Rest State --------------------------------------------------------------------
  override def postStop: Unit = {
    println("ServiceMain Stop!")
  }

  override def preStart: Unit = {
    println("Ready for the REST command!")
  }
}
