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
import persistence.reservation.model.Reservation
import persistence.facility.model.Facility

// DAO: 予約情報
//~~~~~~~~~~~~~~~~~~
class ReservationDAO @javax.inject.Inject()(
  val dbConfigProvider: DatabaseConfigProvider
)  extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

    // --[ リソース定義 ] --------------------------------------------------------
  lazy val slick = TableQuery[ReservationTable]

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
  class ReservationTable(tag: Tag) extends Table[Reservation](tag, "reservation") {


    // Table's columns
    /* @1 */ def id            = column[Reservation.Id]    ("id", O.PrimaryKey, O.AutoInc)
    /* @2 */ def facilityId    = column[Facility.Id]    ("facility_id")
    /* @3 */ def startDate          = column[String]         ("start_date")
    /* @4 */ def endDate       = column[String]         ("end_date")
    /* @5 */ def userId   = column[String]         ("user_id")
    /* @6 */ def userType   = column[Int]         ("user_type")
    /* @7 */ def updatedAt     = column[LocalDateTime]  ("updated_at")
    /* @8 */ def createdAt     = column[LocalDateTime]  ("created_at")

    // The * projection of the table
    def * = (
      id.?, facilityId, startDate, endDate, userId,userType,
      updatedAt, createdAt
    ) <> (
      /** The bidirectional mappings : Tuple(table) => Model */
      (Reservation.apply _).tupled,
      /** The bidirectional mappings : Model => Tuple(table) */
      (v: TableElementType) => Reservation.unapply(v).map(_.copy(
        _7 = LocalDateTime.now
      ))
    )
  }
}