/*
 * This file is part of the Nextbeat services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */
package persistence.reservation.dao

import java.time.LocalDateTime
import java.time.LocalDate

import scala.concurrent.{ExecutionContext, Future}
import slick.jdbc.JdbcProfile
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import persistence.reservation.model.Reservation
import persistence.facility.model.Facility
import persistence.reservation.model.Reservation.Id

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
   * 予約を取得
   */ 
  def get(id: Reservation.Id): Future[Option[Reservation]] =
    db.run {
      slick
        .filter(_.id === id)
        .result.headOption
    }

  def update(id: Long, startDate:LocalDate,endDate:LocalDate):  Unit  =
    db.run {
      slick
        .filter(_.id === id)
        .map(p => (p.startDate, p.endDate))
        .update((startDate, endDate))
    }

  /**
   * 予約を更新
   */
  def updateDuration(id: Long, startDate: LocalDate, endDate: LocalDate)(implicit ex: ExecutionContext):  Unit  = {
    db.run {
      for {
        old <- slick.filter(_.id === id).result.headOption
        _    = old match {
          case Some(_) => slick.filter(_.id === id).map(p => (p.startDate, p.endDate)).update((startDate, endDate))
          case None    => DBIO.successful(0)
        }
      } yield old
    }
  }

  /**
    * 新しく予約を追加する
    */
  def create(data: Reservation): Future[Id] = {
   db.run {
     data.id match {
       case None => slick returning slick.map(_.id) += data
       case Some(_) => DBIO.failed(
         new IllegalArgumentException("The given object is already assigned id.")
       )
     }
   }
  }

  def create(facilityId: Facility.Id ,startDate: LocalDate, endDate: LocalDate, userId: Long,userType:Int): Unit =
    db.run {
      slick
        .map(p => (p.facilityId, p.startDate, p.endDate, p.userId,p.userType)) += ((facilityId, startDate, endDate, userId, userType))
    }

  def delete(id: Long): Unit =
    db.run {
      slick
        .filter(_.id === id)
        .delete
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
    /* @1 */ def id            = column[Reservation.Id] ("id", O.PrimaryKey, O.AutoInc)
    /* @2 */ def facilityId    = column[Facility.Id]    ("facility_id")
    /* @3 */ def startDate     = column[LocalDate]      ("start_date")
    /* @4 */ def endDate       = column[LocalDate]      ("end_date")
    /* @5 */ def userId        = column[Long]           ("user_id")
    /* @6 */ def userType      = column[Int]            ("user_type")
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
