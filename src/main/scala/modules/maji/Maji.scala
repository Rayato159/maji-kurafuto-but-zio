package modules.maji

import zio.json._

case class Maji(
                 var id: Int = 0,
                 var title: String = "",
                 var description: String = "",
                 var damage: Int = -1,
               )
object Maji:
  implicit val decoder: JsonDecoder[Maji] = DeriveJsonDecoder.gen[Maji]
  implicit val encoder: JsonEncoder[Maji] = DeriveJsonEncoder.gen[Maji]
