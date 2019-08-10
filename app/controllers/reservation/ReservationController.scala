/*
 * This file is part of Nextbeat services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */

package controllers.reservation

import play.api.i18n.I18nSupport
import play.api.mvc.{AbstractController, MessagesControllerComponents}
import persistence.reservation.dao.ReservationDAO
import persistence.reservation.model.Reservation.formForReservationAdd
import model.site.reservation.SiteViewValueReservationAdd
import model.component.util.ViewValuePageLayout
import persistence.facility.dao.FacilityDAO


// 施設
//~~~~~~~~~~~~~~~~~~~~~
class ReservationController @javax.inject.Inject()(
  val reservationDao: ReservationDAO,
  val daoFacility: FacilityDAO,
  cc: MessagesControllerComponents
) extends AbstractController(cc) with I18nSupport {
  implicit lazy val executionContext = defaultExecutionContext

  /**
    * 施設予約ページ
    */
  def add(id: Long) = Action.async { implicit request =>
      for {
      facilitySeq <- daoFacility.get(id)
      } yield {
      val vv = SiteViewValueReservationAdd(
        layout     = ViewValuePageLayout(id = request.uri),
        facilities = facilitySeq
      )
      Ok(views.html.site.reservation.add.Main(vv, formForReservationAdd))
    }
  }

}
