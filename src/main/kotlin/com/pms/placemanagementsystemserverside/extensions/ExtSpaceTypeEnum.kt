package com.pms.placemanagementsystemserverside.extensions

import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum

fun SpaceTypeEnum.isComputerLab(): Boolean = this == SpaceTypeEnum.COMPUTER_LAB