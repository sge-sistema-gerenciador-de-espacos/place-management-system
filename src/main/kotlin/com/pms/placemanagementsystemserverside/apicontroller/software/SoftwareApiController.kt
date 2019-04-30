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

    override fun create(item: SoftwareModel): ResponseEntity<Unit> {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = softwareService.create(item)
            ResponseEntity.created(URI.create("/softwares/${itemUpdated.id}")).build()
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun readByFilter(item: SoftwareModel): ResponseEntity<List<SoftwareModel>> {
        var filteredSoftwares: List<SoftwareModel>? = null

        return try {
            logger.info("readByFilter::item: $item")
            filteredSoftwares = softwareService.read()
            logger.info("readByFilter::filteredSoftwares: $filteredSoftwares")
            ResponseEntity.ok(filteredSoftwares)

        } catch (e: Exception) {
            ResponseEntity(filteredSoftwares, HttpStatus.NOT_FOUND)
        }

    }

    override fun read(): ResponseEntity<List<SoftwareModel>> {
        val softwareModelList = softwareService.read()
        logger.info("read::softwareModelList: $softwareModelList")
        return ResponseEntity.ok(softwareModelList)
    }

    override fun update(item: SoftwareModel): ResponseEntity<SoftwareModel> {
        return try {
            logger.info("read::update: $item")
            softwareService.update(item)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun delete(id: Long): ResponseEntity<Unit> {
        return try {
            softwareService.delete(id)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }

    }

}