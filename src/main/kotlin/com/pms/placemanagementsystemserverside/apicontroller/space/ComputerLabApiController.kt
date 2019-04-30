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
class ComputerLabApiController : ApiController<ComputerLabModel> {

    private val logger = LoggerFactory.getLogger(SpaceApiController::class.java)

    @Autowired
    private lateinit var spaceService: SpaceService

    override fun create(item: ComputerLabModel): ResponseEntity<Unit> {
        return try {
            logger.info("create::item: $item")
            spaceService.create(item)
            ResponseEntity.created(URI.create("/spaces/${item.id}")).build()

        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun update(item: ComputerLabModel): ResponseEntity<ComputerLabModel> {
        return try {
            logger.info("read::update: $item")
            spaceService.update(item)
            ResponseEntity.noContent().build()

        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    /**
     * Using from SpaceApiController
     */
    override fun readByFilter(item: ComputerLabModel): ResponseEntity<List<ComputerLabModel>> {
        return ResponseEntity(mutableListOf(), HttpStatus.NOT_FOUND)
    }

    /**
     * Using from SpaceApiController
     */
    override fun read(): ResponseEntity<List<ComputerLabModel>> {
        return ResponseEntity(mutableListOf(), HttpStatus.NOT_FOUND)
    }

    /**
     * Using from SpaceApiController
     */
    override fun delete(id: Long): ResponseEntity<Unit> {
        return ResponseEntity.notFound().build()
    }

}