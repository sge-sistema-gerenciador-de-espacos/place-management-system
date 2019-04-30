package com.pms.placemanagementsystemserverside.apicontroller.software

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.software.SoftwareModel
import com.pms.placemanagementsystemserverside.service.software.SoftwareService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(
        value = ["/pms-api/softwares"],
        consumes = ["application/json"],
        produces = ["application/json"]
)
class SoftwareApiController : ApiController<SoftwareModel> {

    private val logger = LoggerFactory.getLogger(SoftwareApiController::class.java)

    @Autowired
    private lateinit var softwareService: SoftwareService

    override fun createResource(item: SoftwareModel): ResponseEntity<Unit> {
        return try {
            logger.info("createResource::item: $item")
            val itemUpdated = softwareService.create(item)
            ResponseEntity.created(URI.create("/softwares/${itemUpdated.id}")).build()
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun selectResourcesByFilter(item: SoftwareModel): ResponseEntity<List<SoftwareModel>> {
        var filteredSoftwares: List<SoftwareModel>? = null

        return try {
            logger.info("selectResourcesByFilter::item: $item")
            filteredSoftwares = softwareService.read()
            logger.info("selectResourcesByFilter::filteredSoftwares: $filteredSoftwares")
            ResponseEntity.ok(filteredSoftwares)

        } catch (e: Exception) {
            ResponseEntity(filteredSoftwares, HttpStatus.NOT_FOUND)
        }

    }

    override fun selectAllResources(): ResponseEntity<List<SoftwareModel>> {
        val softwareModelList = softwareService.read()
        logger.info("selectAllResources::softwareModelList: $softwareModelList")
        return ResponseEntity.ok(softwareModelList)
    }

    override fun updateResource(item: SoftwareModel): ResponseEntity<SoftwareModel> {
        return try {
            logger.info("selectAllResources::updateResource: $item")
            softwareService.update(item)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun deleteResource(id: Long): ResponseEntity<Unit> {
        return try {
            softwareService.delete(id)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }

    }

}