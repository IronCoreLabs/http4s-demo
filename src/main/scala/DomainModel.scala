package http4sDemo

import _root_.argonaut._
import _root_.argonaut.Argonaut._
import org.http4s.argonaut._
import org.http4s.{ EntityDecoder, EntityEncoder }

final case class Musician(
  id: Int, // unique primary key for record
  firstName: String,
  lastName: String,
  instrument: List[String]
)

object Musician {
  implicit val MusicianCodecJson: CodecJson[Musician] =
    Argonaut.casecodec4(Musician.apply, Musician.unapply)(
      "id", "firstName", "lastName", "instrument"
    )
  implicit val MusicianEntityDecoder: EntityDecoder[Musician] = jsonOf[Musician]
  implicit val MusicianEntityEncoder: EntityEncoder[Musician] = jsonEncoderOf[Musician]
}

final case class Band(
  id: Int, // unique primary key for record
  name: String,
  member: List[Int] // list of the ids of the musicians that belong to the band
)

object Band {
  implicit val BandCodecJson: CodecJson[Band] =
    Argonaut.casecodec3(Band.apply, Band.unapply)(
      "id", "name", "member"
    )
  implicit val BandEntityDecoder: EntityDecoder[Band] = jsonOf[Band]
  implicit val BandEntityEncoder: EntityEncoder[Band] = jsonEncoderOf[Band]
}

final case class Album(
  id: Int, // unique primary key for record
  name: String,
  band: Int, // ID of the band that released the album
  releaseYear: Int
)

object Album {
  implicit val AlbumCodecJson: CodecJson[Album] =
    Argonaut.casecodec4(Album.apply, Album.unapply)(
      "id", "name", "band", "releaseYear"
    )
  implicit val AlbumEntityDecoder: EntityDecoder[Album] = jsonOf[Album]
  implicit val AlbumEntityEncoder: EntityEncoder[Album] = jsonEncoderOf[Album]
}
