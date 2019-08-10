/*
 * This file is part of the Nextbeat services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */
package persistence.reservation.dao

import java.time.LocalDateTime
import scala.concurrent.Future

import slick.jdbc.JdbcProfile
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import persistence.facility.model.Reservation
import persistence.geo.model.Location

// DAO: 予約情報
//~~~~~~~~~~~~~~~~~~
class ReservationDAO @javax.inject.Inject()(
  val dbConfigProvider: DatabaseConfigProvider
)  extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._
// --[ データ処理定義 ] ------------------------------------------------------
  /**
   * 予定を取得
   */ 
  def get(id: Reservation.Id): Future[Option[Reservation]] =
    db.run {
      slick
        .filter(_.id === id)
        .result.headOption
    }
  /**
   * 施設IDから予定を取得
   */ 
  def filterByFacilityIds(facilityIds: Seq[Facility.Id]): Future[Seq[Reservation]] =
    db.run {
      slick
        .filter(_.facilityId inSet facilityIds)
        .result
    }

  // --[ テーブル定義 ] --------------------------------------------------------
  class FacilityTable(tag: Tag) extends Table[Facility](tag, "facility") {


    // Table's columns
    /* @1 */ def id            = column[Facility.Id]    ("id", O.PrimaryKey, O.AutoInc)
    /* @2 */ def locationId    = column[Location.Id]    ("location_id")
    /* @3 */ def name          = column[String]         ("name")
    /* @4 */ def address       = column[String]         ("address")
    /* @5 */ def description   = column[String]         ("description")
    /* @6 */ def updatedAt     = column[LocalDateTime]  ("updated_at")
    /* @7 */ def createdAt     = column[LocalDateTime]  ("created_at")

    // The * projection of the table
    def * = (
      id.?, locationId, name, address, description,
      updatedAt, createdAt
    ) <> (
      /** The bidirectional mappings : Tuple(table) => Model */
      (Facility.apply _).tupled,
      /** The bidirectional mappings : Model => Tuple(table) */
      (v: TableElementType) => Facility.unapply(v).map(_.copy(
        _6 = LocalDateTime.now
      ))
    )
  }
}