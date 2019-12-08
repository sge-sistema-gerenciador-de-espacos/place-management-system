package com.pms.placemanagementsystemserverside

import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel

//@RunWith(MockitoJUnitRunner::class)
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

    //    @Before
    fun setUp() {
//        MockitoAnnotations.initMocks(this)
    }

    //    @Test
    fun print_instanceMocks() {
           print("\n\n User = $userModelList \n\n Space1 = $space1 \n\n Space2 = $space2 \n\n")
    }

}