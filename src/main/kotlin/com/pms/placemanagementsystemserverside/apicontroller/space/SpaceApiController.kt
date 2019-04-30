package com.pms.placemanagementsystemserverside.apicontroller.space

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.service.space.SpaceService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
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

    private val logger = LoggerFactory.getLogger(SpaceApiController::class.java)

    @Autowired
    private lateinit var spaceService: SpaceService

    override fun createResource(item: SpaceModel): ResponseEntity<Unit> {
        return try {
            logger.info("createResource::item: $item")
            val itemUpdated = spaceService.saveSpace(item)
            ResponseEntity.created(URI.create("/spaces/${itemUpdated.id}")).build()
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun selectResourcesByFilter(item: SpaceModel): ResponseEntity<List<SpaceModel>> {
        var filteredSpaces: List<SpaceModel>? = null

        return try {
            logger.info("selectResourcesByFilter::item: $item")
            filteredSpaces = spaceService.listSpaces(item)
            logger.info("selectResourcesByFilter::filteredSpaces: $filteredSpaces")
            ResponseEntity.ok(filteredSpaces)

        } catch (e: Exception) {
            ResponseEntity(filteredSpaces, HttpStatus.NOT_FOUND)
        }

    }

    override fun selectAllResources(): ResponseEntity<List<SpaceModel>> {
        val spaceModelList = spaceService.listSpaces(null)
        logger.info("selectAllResources::spaceModelList: $spaceModelList")
        return ResponseEntity.ok(spaceModelList)
    }

    override fun updateResource(item: SpaceModel): ResponseEntity<SpaceModel> {
        return try {
            logger.info("selectAllResources::updateResource: $item")
            spaceService.updateSpace(item)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun deleteResource(id: Long): ResponseEntity<Unit> {
        return try {
            spaceService.deleteSpace(id)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }

    }

}