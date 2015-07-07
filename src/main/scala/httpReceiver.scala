package httpReceiver

import akka.actor.{ActorRef, ActorSystem}
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

class HttpReceiver()(implicit val actorSystem: ActorSystem) {

  implicit val log = Logging(actorSystem, "HttpReceiver")

  implicit val materializer = ActorMaterializer()

  def doBind(interface: String, port: Int): Unit = {

    val route = get {
              complete("Akka")
          }

    Http().bindAndHandle(route, interface, port)
  }

}

object HttpReceiver {

  def bind(interface: String, port: Int, actorSystem: ActorSystem): Unit =
    new HttpReceiver()(actorSystem).doBind(interface, port)

}
