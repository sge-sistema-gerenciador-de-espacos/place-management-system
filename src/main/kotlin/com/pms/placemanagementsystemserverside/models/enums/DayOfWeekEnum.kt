package com.pms.placemanagementsystemserverside.models.enums

import org.joda.time.DateTimeConstants

enum class DayOfWeekEnum(val apiValue: Int, val dateTimeConstants: Int) {
    SUNDAY(1, DateTimeConstants.SUNDAY),
    MONDAY(2, DateTimeConstants.MONDAY),
    TUESDAY(3, DateTimeConstants.TUESDAY),
    WEDNESDAY(4, DateTimeConstants.WEDNESDAY),
    THURSDAY(5, DateTimeConstants.THURSDAY),
    FRIDAY(6, DateTimeConstants.FRIDAY),
    SATURDAY(7, DateTimeConstants.SATURDAY),
    UNKNOWN(0, 0)
}