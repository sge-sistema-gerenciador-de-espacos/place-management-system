package com.pms.placemanagementsystemserverside.extensions

import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum

fun SpaceTypeEnum.serializeToInt(): Int =
        when (this) {
            SpaceTypeEnum.CLASSROOM -> 1
            SpaceTypeEnum.COMPUTER_LAB -> 2
            else -> 0
        }