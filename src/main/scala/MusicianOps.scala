package http4sDemo

import scalaz.concurrent.Task
import org.http4s._
import org.http4s.dsl._

trait MusicianOps extends MyOps {
  def routes: MyService.Routes = {
    case req @ GET -> Root / "musicians" => fetchMusicianList(req)
    case req @ GET -> Root / "musicians" / musicianID => fetchMusician(req, musicianID)
    case req @ POST -> Root / "musicians" => createMusician(req)
    case req @ PUT -> Root / "musicians" / musicianID => replaceMusician(req, musicianID)
    case DELETE -> Root / "musicians" / musicianID => deleteMusician(musicianID)
  }

  def fetchMusicianList(req: Request): Task[Response]
  def fetchMusician(req: Request, musicianID: String): Task[Response]
  def createMusician(req: Request): Task[Response]
  def replaceMusician(req: Request, musicianID: String): Task[Response]
  def deleteMusician(musicianID: String): Task[Response]
}

object ProductionMusicianOps extends MusicianOps {
  def fetchMusicianList(req: Request): Task[Response] = BadRequest("Not implemented yet")

  def fetchMusician(req: Request, musicianID: String): Task[Response] = BadRequest("Not implemented yet")

  def createMusician(req: Request): Task[Response] = BadRequest("Not implemented yet")

  def replaceMusician(req: Request, musicianID: String): Task[Response] = BadRequest("Not implemented yet")

  def deleteMusician(musicianID: String): Task[Response] = BadRequest("Not implemented yet")
}

object MockMusicianOps extends MusicianOps {
  def fetchMusicianList(req: Request): Task[Response] = Ok("fetch musician list")

  def fetchMusician(req: Request, musicianID: String): Task[Response] = {
    Ok(Musician(musicianID.toInt, "Jimi", "Hendrix", List("guitar")))
  }

  def createMusician(req: Request): Task[Response] = Ok("created musician")

  def replaceMusician(req: Request, musicianID: String): Task[Response] = Ok("replaced musician")

  def deleteMusician(musicianID: String): Task[Response] = Ok("deleted musician")
}
