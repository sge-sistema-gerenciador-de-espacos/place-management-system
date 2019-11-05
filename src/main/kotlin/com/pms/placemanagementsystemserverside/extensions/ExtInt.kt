package com.pms.placemanagementsystemserverside.extensions

import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum

fun Int.trueOrFalse(): Boolean = this == 1

fun Int.deserializeToSpaceEnumType(): SpaceTypeEnum {
    return when (this) {
        1 -> SpaceTypeEnum.CLASSROOM
        2 -> SpaceTypeEnum.COMPUTER_LAB
        else -> SpaceTypeEnum.UNKNOWN
    }
}