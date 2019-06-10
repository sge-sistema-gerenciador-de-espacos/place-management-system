package com.pms.placemanagementsystemserverside

import com.pms.placemanagementsystemserverside.models.space.ComputerLabModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
open class BaseTest {

    protected val userModelList = InstanceMocks.getUserModelList()

    protected val space1 = SpaceModel(
            id = 1,
            numberOfChairs = 15,
            hasBoard = true
    )

    protected val space2 = SpaceModel(
            id = 2,
            numberOfChairs = 15,
            hasSmartBoard = true
    )

    private val softwares = mutableListOf(
            SoftwareModel(id = 1, name = "java"),
            SoftwareModel(id = 2, name = "go")
    )

    protected val computerLab = ComputerLabModel(
            id = 3,
            hasBoard =
            false,
            numberOfChairs = 30,
            name = "labA",
            softwares = softwares,
            numberOfPcs = 15,
            hasSmartBoard = false,
            hasProjector = true
    )

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun print_instanceMocks() {
        print("\n\n User = $userModelList \n\n Space1 = $space1 \n\n Space2 = $space2 \n\n CompLab = $computerLab \n\n")
    }

}