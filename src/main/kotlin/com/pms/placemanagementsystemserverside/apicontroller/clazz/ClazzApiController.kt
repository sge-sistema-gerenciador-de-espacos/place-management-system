package com.pms.placemanagementsystemserverside.apicontroller.clazz

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import com.pms.placemanagementsystemserverside.service.clazz.ClazzService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(
        value = ["/pms-api/clazzs"],
        consumes = ["application/json"],
        produces = ["application/json"]
)
class ClazzApiController : ApiController<ClazzModel> {

    private val logger = LoggerFactory.getLogger(ClazzApiController::class.java)

    @Autowired
    private lateinit var clazzService: ClazzService

    override fun create(item: ClazzModel): ResponseEntity<Unit> {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = clazzService.create(item)
            ResponseEntity.created(URI.create("/clazzs/${itemUpdated.id}")).build()
        } catch (e: Exception) {
            logger.info("create::catch: ${e.message}")
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun readByFilter(item: ClazzModel): ResponseEntity<List<ClazzModel>> {
        var filteredClazzs: List<ClazzModel>? = null

        return try {
            logger.info("readByFilter::item: $item")
            filteredClazzs = clazzService.read()
            logger.info("readByFilter::filteredClazzs: $filteredClazzs")
            ResponseEntity.ok(filteredClazzs)

        } catch (e: Exception) {
            ResponseEntity(filteredClazzs, HttpStatus.NOT_FOUND)
        }

    }

    override fun read(): ResponseEntity<List<ClazzModel>> {
        val clazzModelList = clazzService.read()
        logger.info("read::clazzModelList: $clazzModelList")
        return ResponseEntity.ok(clazzModelList)
    }

    override fun update(item: ClazzModel, id: Long): ResponseEntity<ClazzModel> {
        return try {
            logger.info("read::update: $item")
            clazzService.update(item)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun delete(id: Long): ResponseEntity<Unit> {
        return try {
            clazzService.delete(id)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }

    }
}