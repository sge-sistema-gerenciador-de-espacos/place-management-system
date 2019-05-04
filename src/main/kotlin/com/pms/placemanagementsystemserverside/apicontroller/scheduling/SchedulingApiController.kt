package com.pms.placemanagementsystemserverside.apicontroller.scheduling

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import com.pms.placemanagementsystemserverside.service.scheduling.SchedulingService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(
        value = ["/pms-api/schedulings"],
        consumes = ["application/json"],
        produces = ["application/json"]
)
class SchedulingApiController : ApiController<SchedulingModel> {

    private val logger = LoggerFactory.getLogger(SchedulingApiController::class.java)

    @Autowired
    private lateinit var schedulingService: SchedulingService

    override fun create(item: SchedulingModel): ResponseEntity<Unit> {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = schedulingService.create(item)
            ResponseEntity.created(URI.create("/schedulings/${itemUpdated.id}")).build()
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun readByFilter(item: SchedulingModel): ResponseEntity<List<SchedulingModel>> {
        var filteredSchedulings: List<SchedulingModel>? = null

        return try {
            logger.info("readByFilter::item: $item")
            filteredSchedulings = schedulingService.read()
            logger.info("readByFilter::filteredSchedulings: $filteredSchedulings")
            ResponseEntity.ok(filteredSchedulings)

        } catch (e: Exception) {
            ResponseEntity(filteredSchedulings, HttpStatus.NOT_FOUND)
        }

    }

    override fun read(): ResponseEntity<List<SchedulingModel>> {
        val schedulingModelList = schedulingService.read()
        logger.info("read::schedulingModelList: $schedulingModelList")
        return ResponseEntity.ok(schedulingModelList)
    }

    override fun update(item: SchedulingModel): ResponseEntity<SchedulingModel> {
        return try {
            logger.info("read::update: $item")
            schedulingService.update(item)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun delete(id: Long): ResponseEntity<Unit> {
        return try {
            schedulingService.delete(id)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }

    }

}