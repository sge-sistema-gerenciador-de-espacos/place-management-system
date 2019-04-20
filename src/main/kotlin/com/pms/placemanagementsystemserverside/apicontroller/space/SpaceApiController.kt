package com.pms.placemanagementsystemserverside.apicontroller.space

import com.pms.placemanagementsystemserverside.apicontroller.BaseApiController
import com.pms.placemanagementsystemserverside.models.ComputerLabModel
import com.pms.placemanagementsystemserverside.models.SoftwareModel
import com.pms.placemanagementsystemserverside.models.SpaceModel
import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
//TODO check if base request mapping is working
@RequestMapping(
        value = ["/pms-api/spaces"]
)
class SpaceApiController : BaseApiController<SpaceModel>() {
//class SpaceApiController : ApiController<SpaceModel> {

    private val logger = LoggerFactory.getLogger(SpaceApiController::class.java)

    override fun createResource(item: SpaceModel): ResponseEntity<SpaceModel> {

        getSpaces().add(item)
        return ResponseEntity.created(URI.create("/spaces")).build()
    }

    override fun selectResourcesByFilter(item: SpaceModel): ResponseEntity<List<SpaceModel>> {
        return ResponseEntity(getSpaces(), HttpStatus.OK)
    }

    override fun selectAllResources(): ResponseEntity<List<SpaceModel>> {
        return ResponseEntity(getSpaces(), HttpStatus.OK)
    }

    override fun updateResource(item: SpaceModel): ResponseEntity<SpaceModel> {
        getSpaces().apply {
            removeIf { it.id == item.id }
            add(item)
        }
        return ResponseEntity.accepted().build()
    }

    override fun deleteResource(id: Long): ResponseEntity<Unit> {
        return ResponseEntity.accepted().build()
    }

    private fun getSpaces(): MutableList<SpaceModel> {

        val spaceModel = SpaceModel(id = 1L, name = "SalaA", numberOfChairs = 12, hasProjector = true,
                hasBoard = false, hasSmartBoard = true, typeOfSpace = TypeOfSpaceEnum.CLASSROOM)

        val computerLabelModel = ComputerLabModel(id = 2L, name = "SalaB", numberOfChairs = 20, hasProjector = true,
                hasBoard = true, hasSmartBoard = false, numberOfPcs = 20, softwares = getSoftwares())

        return mutableListOf(spaceModel, computerLabelModel)
    }

    private fun getSoftwares(): MutableList<SoftwareModel> =
            mutableListOf(
                    SoftwareModel(id = 1L, name = "Intellij"),
                    SoftwareModel(id = 2L, name = "AndroidStudio")
            )
}