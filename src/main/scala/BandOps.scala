package http4sDemo

import scalaz.concurrent.Task
import org.http4s._
import org.http4s.dsl._

trait BandOps extends MyOps {
  def routes: MyService.Routes = {
    case req @ GET -> Root / "bands" => fetchBandList(req)
    case req @ GET -> Root / "bands" / bandID => fetchBand(req, bandID)
    case req @ POST -> Root / "bands" => createBand(req)
    case req @ PUT -> Root / "bands" / bandID => replaceBand(req, bandID)
    case DELETE -> Root / "bands" / bandID => deleteBand(bandID)
  }

  def fetchBandList(req: Request): Task[Response]
  def fetchBand(req: Request, bandID: String): Task[Response]
  def createBand(req: Request): Task[Response]
  def replaceBand(req: Request, bandID: String): Task[Response]
  def deleteBand(bandID: String): Task[Response]
}

object ProductionBandOps extends BandOps {
  def fetchBandList(req: Request): Task[Response] = BadRequest("Not implemented yet")

  def fetchBand(req: Request, bandID: String): Task[Response] = BadRequest("Not implemented yet")

  def createBand(req: Request): Task[Response] = BadRequest("Not implemented yet")

  def replaceBand(req: Request, bandID: String): Task[Response] = BadRequest("Not implemented yet")

  def deleteBand(bandID: String): Task[Response] = BadRequest("Not implemented yet")
}

object MockBandOps extends BandOps {
  def fetchBandList(req: Request): Task[Response] = Ok("fetch band list")

  def fetchBand(req: Request, bandID: String): Task[Response] = {
    Ok(Band(bandID.toInt, "Jimi Hendrix Experience", List(1)))
  }

  def createBand(req: Request): Task[Response] = Ok("created band")

  def replaceBand(req: Request, bandID: String): Task[Response] = Ok("replaced band")

  def deleteBand(bandID: String): Task[Response] = Ok("deleted band")
}
