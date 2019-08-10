/*
 * This file is part of the Nextbeat services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */
package persistence.reservation.model

import play.api.data._
import play.api.data.Forms._
import java.time.LocalDateTime
import java.time.LocalDate
import persistence.facility.model.Facility


// 予約状況情報
case class Reservation(
  id:          Option[Reservation.Id],                // 予約ID
  facilityId: Facility.Id,                        // 施設ID
  startDate: LocalDate, //チェックイン   
  endDate: LocalDate, //チェックアウト                  
  userId: Long,          // 予約者のID
  userType: Int, // 予約者が施設所有者かお客様か
  updatedAt:   LocalDateTime = LocalDateTime.now,  // データ更新日
  createdAt:   LocalDateTime = LocalDateTime.now   // データ作成日
)


// 施設検索
case class ReservationSearch(
  facilityIdOpt : Option[Facility.Id]
)

case class ReservationAdd(
  name:            String,
  address:         String,
  company_name:    String
)


// コンパニオンオブジェクト
//~~~~~~~~~~~~~~~~~~~~~~~~~~
object Reservation {

  // --[ 管理ID ]---------------------------------------------------------------
  type Id = Long

  // --[ フォーム定義 ]---------------------------------------------------------
  val formForReservationSearch = Form(
    mapping(
      "facilityIdOpt" -> optional(longNumber),
    )(ReservationSearch.apply)(ReservationSearch.unapply)
  )

   val formForReservationAdd = Form(
    mapping(
      "name" -> text,
      "address" -> text,
      "company_name"  -> text,
    )(ReservationAdd.apply)(ReservationAdd.unapply)
  )
}
