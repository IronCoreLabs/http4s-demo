package http4sDemo

import scalaz.concurrent.Task
import org.http4s._
import org.http4s.dsl._

trait AlbumOps extends MyOps {
  def routes: MyService.Routes = {
    case req @ GET -> Root / "albums" => fetchAlbumList(req)
    case req @ GET -> Root / "albums" / albumID => fetchAlbum(req, albumID)
    case req @ POST -> Root / "albums" => createAlbum(req)
    case req @ PUT -> Root / "albums" / albumID => replaceAlbum(req, albumID)
    case DELETE -> Root / "albums" / albumID => deleteAlbum(albumID)
  }

  def fetchAlbumList(req: Request): Task[Response]
  def fetchAlbum(req: Request, albumID: String): Task[Response]
  def createAlbum(req: Request): Task[Response]
  def replaceAlbum(req: Request, albumID: String): Task[Response]
  def deleteAlbum(albumID: String): Task[Response]
}

object ProductionAlbumOps extends AlbumOps {
  def fetchAlbumList(req: Request): Task[Response] = BadRequest("Not implemented yet")

  def fetchAlbum(req: Request, albumID: String): Task[Response] = BadRequest("Not implemented yet")

  def createAlbum(req: Request): Task[Response] = BadRequest("Not implemented yet")

  def replaceAlbum(req: Request, albumID: String): Task[Response] = BadRequest("Not implemented yet")

  def deleteAlbum(albumID: String): Task[Response] = BadRequest("Not implemented yet")
}

object MockAlbumOps extends AlbumOps {
  def fetchAlbumList(req: Request): Task[Response] = Ok("fetch album list")

  private[this] val releaseYear = 1967

  def fetchAlbum(req: Request, albumID: String): Task[Response] = {
    Ok(Album(albumID.toInt, "Are You Experienced?", 1, releaseYear))
  }

  def createAlbum(req: Request): Task[Response] = Ok("created album")

  def replaceAlbum(req: Request, albumID: String): Task[Response] = Ok("replaced album")

  def deleteAlbum(albumID: String): Task[Response] = Ok("deleted album")
}
