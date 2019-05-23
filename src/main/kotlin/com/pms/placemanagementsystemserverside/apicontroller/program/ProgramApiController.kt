package com.pms.placemanagementsystemserverside.apicontroller.program

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.program.ProgramModel
import com.pms.placemanagementsystemserverside.service.program.ProgramService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(
        value = ["/pms-api/programs"],
        consumes = ["application/json"],
        produces = ["application/json"]
)
class ProgramApiController : ApiController<ProgramModel> {

    private val logger = LoggerFactory.getLogger(ProgramApiController::class.java)

    @Autowired
    private lateinit var programService: ProgramService

    override fun create(item: ProgramModel): ResponseEntity<Unit> {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = programService.create(item)
            ResponseEntity.created(URI.create("/programs/${itemUpdated.id}")).build()
        } catch (e: Exception) {
            logger.info("create::catch: ${e.message}")
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun readByFilter(item: ProgramModel): ResponseEntity<List<ProgramModel>> {
        var filteredPrograms: List<ProgramModel>? = null

        return try {
            logger.info("readByFilter::item: $item")
            filteredPrograms = programService.read()
            logger.info("readByFilter::filteredPrograms: $filteredPrograms")
            ResponseEntity.ok(filteredPrograms)

        } catch (e: Exception) {
            ResponseEntity(filteredPrograms, HttpStatus.NOT_FOUND)
        }

    }

    override fun read(): ResponseEntity<List<ProgramModel>> {
        val programModelList = programService.read()
        logger.info("read::programModelList: $programModelList")
        return ResponseEntity.ok(programModelList)
    }

    override fun update(item: ProgramModel, id: Long): ResponseEntity<ProgramModel> {
        return try {
            logger.info("read::update: $item")
            programService.update(item)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun delete(id: Long): ResponseEntity<Unit> {
        return try {
            programService.delete(id)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }

    }
}