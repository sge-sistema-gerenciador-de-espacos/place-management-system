package com.pms.placemanagementsystemserverside.extensions

import com.pms.placemanagementsystemserverside.models.enums.ActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum

fun Int.trueOrFalse(): Boolean = this == 1

fun Int.deserializeToSpaceEnumType(): SpaceTypeEnum =
        when (this) {
            1 -> SpaceTypeEnum.CLASSROOM
            2 -> SpaceTypeEnum.COMPUTER_LAB
            else -> SpaceTypeEnum.UNKNOWN
        }

fun Int.deserializeToActivationModelStatusEnum(): ActivationModelStatusEnum =
        when (this) {
            0 -> ActivationModelStatusEnum.INACTIVE
            1 -> ActivationModelStatusEnum.ACTIVE
            else -> ActivationModelStatusEnum.UNKNOWN
        }