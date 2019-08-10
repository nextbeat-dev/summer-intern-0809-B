/*
 * This file is part of the MARIAGE services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */

package model.site.reservation

import model.component.util.ViewValuePageLayout
import persistence.facility.model.Facility
import persistence.reservation.model.Reservation

// 表示: 施設一覧
//~~~~~~~~~~~~~~~~~~~~~
case class SiteViewValueFacilityList(
  layout:   ViewValuePageLayout,
  reservations: Seq[Reservation]
)