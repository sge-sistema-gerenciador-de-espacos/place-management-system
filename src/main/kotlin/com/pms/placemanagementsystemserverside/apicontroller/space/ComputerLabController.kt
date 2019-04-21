package com.pms.placemanagementsystemserverside.apicontroller.space

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.space.ComputerLabModel
import org.slf4j.LoggerFactory
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

    private val LOGGER = LoggerFactory.getLogger(SpaceApiController::class.java)

    override fun createResource(item: ComputerLabModel): ResponseEntity<Unit> {
        try {
            LOGGER.info("createResource::item: $item")
//            spaceModelList.add(item)
            return ResponseEntity.created(URI.create("/spaces/${item.id}")).build()
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun updateResource(item: ComputerLabModel): ResponseEntity<ComputerLabModel> {
        try {
            LOGGER.info("selectAllResources::updateResource: $item")
//            spaceModelList.apply {
//                removeIf { it.id == item.id }
//                add(item)
//            }
            return ResponseEntity.noContent().build()
        } catch (e: Exception) {
            return ResponseEntity.notFound().build()
        }
    }

    /**
     * Using from SpaceApiController
     */
    override fun selectResourcesByFilter(item: ComputerLabModel): ResponseEntity<List<ComputerLabModel>> {
        return ResponseEntity(mutableListOf(), HttpStatus.NOT_FOUND)
    }

    override fun selectAllResources(): ResponseEntity<List<ComputerLabModel>> {
        return ResponseEntity(mutableListOf(), HttpStatus.NOT_FOUND)
    }

    override fun deleteResource(id: Long): ResponseEntity<Unit> {
        return ResponseEntity.notFound().build()
    }

}