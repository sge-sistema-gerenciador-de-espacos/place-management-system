package com.pms.placemanagementsystemserverside.apicontroller.space

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.space.ComputerLabModel
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
        value = ["/pms-api/spaces/computer-lab"],
        consumes = ["application/json"],
        produces = ["application/json"]
)
class ComputerLabController : ApiController<ComputerLabModel> {

    private val logger = LoggerFactory.getLogger(SpaceApiController::class.java)

    @Autowired
    private lateinit var spaceService: SpaceService

    override fun createResource(item: ComputerLabModel): ResponseEntity<Unit> {
        return try {
            logger.info("createResource::item: $item")
            spaceService.create(item)
            ResponseEntity.created(URI.create("/spaces/${item.id}")).build()

        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun updateResource(item: ComputerLabModel): ResponseEntity<ComputerLabModel> {
        return try {
            logger.info("selectAllResources::updateResource: $item")
            spaceService.update(item)
            ResponseEntity.noContent().build()

        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    /**
     * Using from SpaceApiController
     */
    override fun selectResourcesByFilter(item: ComputerLabModel): ResponseEntity<List<ComputerLabModel>> {
        return ResponseEntity(mutableListOf(), HttpStatus.NOT_FOUND)
    }

    /**
     * Using from SpaceApiController
     */
    override fun selectAllResources(): ResponseEntity<List<ComputerLabModel>> {
        return ResponseEntity(mutableListOf(), HttpStatus.NOT_FOUND)
    }

    /**
     * Using from SpaceApiController
     */
    override fun deleteResource(id: Long): ResponseEntity<Unit> {
        return ResponseEntity.notFound().build()
    }

}