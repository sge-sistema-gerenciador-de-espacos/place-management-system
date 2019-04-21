package com.pms.placemanagementsystemserverside.apicontroller.space

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum
import com.pms.placemanagementsystemserverside.models.space.ComputerLabModel
import com.pms.placemanagementsystemserverside.models.space.SoftwareModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(
        value = ["/pms-api/spaces"],
        consumes = ["application/json"],
        produces = ["application/json"]
)
class SpaceApiController : ApiController<SpaceModel> {

    private val LOGGER = LoggerFactory.getLogger(SpaceApiController::class.java)
    private val spaceModelList = getSpaces()

    override fun createResource(item: SpaceModel): ResponseEntity<Unit> {
        try {
            LOGGER.info("createResource::item: $item")
            spaceModelList.add(item)
            return ResponseEntity.created(URI.create("/spaces/${item.id}")).build()
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun selectResourcesByFilter(item: SpaceModel): ResponseEntity<List<SpaceModel>> {
        val filteredSpaces = mutableListOf<SpaceModel>()

        try {
            LOGGER.info("selectResourcesByFilter::item: $item")
            filteredSpaces.addAll(spaceModelList.filter { it.id == item.id })
            LOGGER.info("selectResourcesByFilter::filteredSpaces: $filteredSpaces")
            return ResponseEntity.ok(filteredSpaces)

        } catch (e: Exception) {
            return ResponseEntity(filteredSpaces, HttpStatus.NOT_FOUND)
        }

    }

    override fun selectAllResources(): ResponseEntity<List<SpaceModel>> {
        LOGGER.info("selectAllResources::spaceModelList: $spaceModelList")
        return ResponseEntity.ok(spaceModelList)
    }

    override fun updateResource(item: SpaceModel): ResponseEntity<SpaceModel> {
        try {
            LOGGER.info("selectAllResources::updateResource: $item")
            spaceModelList.apply {
                removeIf { it.id == item.id }
                add(item)
            }
            return ResponseEntity.noContent().build()
        } catch (e: Exception) {
            return ResponseEntity.notFound().build()
        }
    }

    override fun deleteResource(id: Long): ResponseEntity<Unit> {
        try {
            return ResponseEntity.noContent().build()
        } catch (e: Exception) {
            return ResponseEntity.notFound().build()
        }

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