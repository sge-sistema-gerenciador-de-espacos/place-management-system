package com.pms.placemanagementsystemserverside

import com.pms.placemanagementsystemserverside.models.space.ComputerLabModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel
import com.pms.placemanagementsystemserverside.models.user.UserModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
open class BaseTest {

    protected val user = UserModel(id = 1)

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

    //TODO Devo usar SpringRunner para executar o banco de dados, talvez @Spy tb esteja errado.
    //TODO Pesquisar como testar um repository fielmente
//    @Spy
//    protected lateinit var spaceRepository: SpaceRepository
//
//    @Spy
//    protected lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
//        MockitoAnnotations.initMocks(this)
//        spaceRepository.create(space1)
//        spaceRepository.create(space2)
//        spaceRepository.create(computerLab)
//        userRepository.create(user)
    }

    @Test
    fun print_instanceMocks() {
        print("\n\n User = $user \n\n Space1 = $space1 \n\n Space2 = $space2 \n\n CompLab = $computerLab \n\n")
    }

//    @Test
//    fun print_savedMocks() {
//        print("\n\n Users = ${userRepository.read()}  \n\n Spaces = ${spaceRepository.read()} \n\n")
//    }

}