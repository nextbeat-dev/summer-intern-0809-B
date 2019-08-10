/*
 * This file is part of the Nextbeat services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */

package persistence.facility.dao

import java.time.LocalDateTime
import scala.concurrent.Future

import slick.jdbc.JdbcProfile
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import persistence.facility.model.Facility
import persistence.geo.model.Location

// DAO: 施設情報
//~~~~~~~~~~~~~~~~~~
class FacilityDAO @javax.inject.Inject()(
  val dbConfigProvider: DatabaseConfigProvider
) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  // --[ リソース定義 ] --------------------------------------------------------
  lazy val slick = TableQuery[FacilityTable]

  // --[ データ処理定義 ] ------------------------------------------------------
  /**
   * 施設を取得
   */
  def get(id: Facility.Id): Future[Option[Facility]] =
    db.run {
      slick
        .filter(_.id === id)
        .result.headOption
    }
  
  /**
   * 施設を全件取得する
   */
  def findAll: Future[Seq[Facility]] =
    db.run {
      slick.result
    }
  /**
   * 地域から施設を取得
   * 検索業件: ロケーションID
   */
  def filterByLocationIds(locationIds: Seq[Location.Id]): Future[Seq[Facility]] =
    db.run {
      slick
        .filter(_.locationId inSet locationIds)
        .result
    }

  // --[ テーブル定義 ] --------------------------------------------------------
  class FacilityTable(tag: Tag) extends Table[Facility](tag, "facility") {


    // Table's columns
    /* @1  */ def id            = column[Facility.Id]    ("id", O.PrimaryKey, O.AutoInc)
    /* @2  */ def name          = column[String]         ("name")
    /* @3  */ def catchCopy     = column[Option[String]] ("catch_copy")
    /* @4  */ def description   = column[String]         ("description")
    /* @5  */ def address       = column[String]         ("address")
    /* @6  */ def locationId    = column[Location.Id]    ("location_id")
    /* @7  */ def url           = column[String]         ("url")
    /* @8  */ def cost          = column[Int]            ("cost")
    /* @9  */ def access        = column[String]         ("access")  
    /* @10 */ def capacity      = column[Int]            ("capacity")
    /* @11 */ def map           = column[String]         ("map")
    /* @12 */ def imagePaths    = column[String]         ("image_paths")
    /* @13 */ def contents      = column[Option[String]] ("contents")
    /* @14 */ def updatedAt     = column[LocalDateTime]  ("updated_at")
    /* @15 */ def createdAt     = column[LocalDateTime]  ("created_at")

    // The * projection of the table
    def * = (
      id.?, name, catchCopy, description, address, locationId, 
      url, cost, access, capacity, map, imagePaths, contents, 
      updatedAt, createdAt
    ) <> (
      /** The bidirectional mappings : Tuple(table) => Model */
      (Facility.apply _).tupled,
      /** The bidirectional mappings : Model => Tuple(table) */
      (v: TableElementType) => Facility.unapply(v).map(_.copy(
        _14 = LocalDateTime.now
      ))
    )
  }
}
