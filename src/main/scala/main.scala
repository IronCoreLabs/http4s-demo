package http4sDemo

import org.http4s.server._
import org.http4s.server.blaze.BlazeBuilder

object MyApp {

  def main(args: Array[String]): Unit = {
    val Port = 8123
    val UrlSuffix = "/api"

    val service: HttpService =
      if (args.length > 0 && args(0) == "-m") {
        println("Using mock service")
        MockService.service
      } else {
        println("Using production service")
        ProductionService.service
      }

    BlazeBuilder.bindHttp(Port)
      .mountService(service, UrlSuffix)
      .run
      .awaitShutdown()
  }
}
