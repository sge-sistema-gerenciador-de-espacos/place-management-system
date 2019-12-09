package com.pms.placemanagementsystemserverside.extensions

import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.DayOfWeekEnum

fun Int.trueOrFalse(): Boolean = this == 1

fun Int.deserializeToActivationModelStatusEnum(): ActivationModelStatusEnum =
        when (this) {
            0 -> ActivationModelStatusEnum.INACTIVE
            1 -> ActivationModelStatusEnum.ACTIVE
            else -> ActivationModelStatusEnum.UNKNOWN
        }

fun Int.deserializeToDayOfWeekEnum(): DayOfWeekEnum =
        when (this) {
            DayOfWeekEnum.SUNDAY.apiValue -> DayOfWeekEnum.SUNDAY
            DayOfWeekEnum.MONDAY.apiValue -> DayOfWeekEnum.MONDAY
            DayOfWeekEnum.TUESDAY.apiValue -> DayOfWeekEnum.TUESDAY
            DayOfWeekEnum.WEDNESDAY.apiValue -> DayOfWeekEnum.WEDNESDAY
            DayOfWeekEnum.THURSDAY.apiValue -> DayOfWeekEnum.THURSDAY
            DayOfWeekEnum.FRIDAY.apiValue -> DayOfWeekEnum.FRIDAY
            DayOfWeekEnum.SATURDAY.apiValue -> DayOfWeekEnum.SATURDAY
            else -> DayOfWeekEnum.UNKNOWN
        }