package http4sDemo

import scala.concurrent.ExecutionContext
import scalaz.concurrent.Task
import org.http4s._
import org.http4s.server._

trait MyService {
  def musicianOps: MusicianOps
  def bandOps: BandOps
  def albumOps: AlbumOps

  def serviceComposer(implicit executionContext: ExecutionContext = ExecutionContext.global): HttpService =
    HttpService(
      musicianOps.routes orElse bandOps.routes orElse albumOps.routes
    )

  lazy val service: HttpService = serviceComposer
}

trait MyOps {
  def routes: MyService.Routes
}

object MyService {
  type Routes = PartialFunction[Request, Task[Response]]
}

object ProductionService extends MyService {
  def musicianOps: MusicianOps = ProductionMusicianOps
  def bandOps: BandOps = ProductionBandOps
  def albumOps: AlbumOps = ProductionAlbumOps
}

object MockService extends MyService {
  def musicianOps: MusicianOps = MockMusicianOps
  def bandOps: BandOps = MockBandOps
  def albumOps: AlbumOps = MockAlbumOps
}
