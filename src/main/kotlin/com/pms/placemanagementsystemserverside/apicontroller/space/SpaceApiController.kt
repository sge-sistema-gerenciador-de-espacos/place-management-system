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

    override fun create(item: SpaceModel): ResponseEntity<Unit> {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = spaceService.create(item)
            ResponseEntity.created(URI.create("/spaces/${itemUpdated.id}")).build()
        } catch (e: Exception) {
            logger.info("create::catch: ${e.message}")
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun readByFilter(item: SpaceModel): ResponseEntity<List<SpaceModel>> {
        var filteredSpaces: List<SpaceModel>? = null

        return try {
            logger.info("readByFilter::item: $item")
            filteredSpaces = spaceService.read()
            logger.info("readByFilter::filteredSpaces: $filteredSpaces")
            ResponseEntity.ok(filteredSpaces)

        } catch (e: Exception) {
            ResponseEntity(filteredSpaces, HttpStatus.NOT_FOUND)
        }

    }

    override fun read(): ResponseEntity<List<SpaceModel>> {
        val spaceModelList = spaceService.read()
        logger.info("read::spaceModelList: $spaceModelList")
        return ResponseEntity.ok(spaceModelList)
    }

    override fun update(item: SpaceModel): ResponseEntity<SpaceModel> {
        return try {
            logger.info("read::update: $item")
            spaceService.update(item)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun delete(id: Long): ResponseEntity<Unit> {
        return try {
            spaceService.delete(id)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }

    }

}