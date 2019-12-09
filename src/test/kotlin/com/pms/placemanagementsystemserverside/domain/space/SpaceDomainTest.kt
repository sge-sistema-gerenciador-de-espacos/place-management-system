package com.pms.placemanagementsystemserverside.domain.space

import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import org.junit.Assert
import org.junit.Test

internal class SpaceDomainTest {

    @Test
    fun `Should match by one specific space`() {
        val subject = SpaceDomain()

        val spaceModeList = listOf(
                SpaceModel(hasBoard = true, type = SpaceTypeEnum.CLASSROOM, numberOfChairs = 10),
                SpaceModel(hasBoard = true, type = SpaceTypeEnum.CLASSROOM, numberOfChairs = 15),
                SpaceModel(type = SpaceTypeEnum.CLASSROOM, numberOfChairs = 20)
        )

        val spaceModeListExpected = listOf(
                SpaceModel(hasBoard = true, type = SpaceTypeEnum.CLASSROOM, numberOfChairs = 10),
                SpaceModel(hasBoard = true, type = SpaceTypeEnum.CLASSROOM, numberOfChairs = 15)
        )

        val spaceIntention = SpaceModel(hasBoard = true, type = SpaceTypeEnum.CLASSROOM, numberOfChairs = 8)

        val spaceModelListActual = subject.filterSpaceListBySpaceIntention(spaceModeList, spaceIntention)

        Assert.assertEquals(spaceModeListExpected, spaceModelListActual)
    }

}