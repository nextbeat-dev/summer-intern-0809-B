/*
 * This file is part of the Nextbeat services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */
package persistence.facility.model

import play.api.data._
import play.api.data.Forms._
import java.time.LocalDateTime
import persistence.geo.model.Facility

// 予約状況情報
case class Reservation(
  id:          Option[Reservation.Id],                // 予約ID
  facility_id: String,                        // 施設IDID
  start_date: String, //チェックイン   
  last_date: String, //チェックアウト                  
  user_id: String,          // 予約者のID
  updatedAt:   LocalDateTime = LocalDateTime.now,  // データ更新日
  createdAt:   LocalDateTime = LocalDateTime.now   // データ作成日
)


// 施設検索
case class ReservationSearch(
  locationIdOpt: Option[Facility.Id]
)

// コンパニオンオブジェクト
//~~~~~~~~~~~~~~~~~~~~~~~~~~
object Reservation {

  // --[ 管理ID ]---------------------------------------------------------------
  type Id = Long

  // --[ フォーム定義 ]---------------------------------------------------------
  val formForReservationSearch = Form(
    mapping(
      "facilityId" -> optional(text),
    )(ReservationSearch.apply)(ReservationSearch.unapply)
  )
}
