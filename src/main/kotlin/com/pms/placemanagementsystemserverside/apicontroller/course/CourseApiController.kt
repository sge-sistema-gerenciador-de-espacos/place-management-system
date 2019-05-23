package com.pms.placemanagementsystemserverside.apicontroller.course

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.course.CourseModel
import com.pms.placemanagementsystemserverside.service.course.CourseService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(
        value = ["/pms-api/courses"],
        consumes = ["application/json"],
        produces = ["application/json"]
)
class CourseApiController : ApiController<CourseModel> {

    private val logger = LoggerFactory.getLogger(CourseApiController::class.java)

    @Autowired
    private lateinit var courseService: CourseService

    override fun create(item: CourseModel): ResponseEntity<Unit> {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = courseService.create(item)
            ResponseEntity.created(URI.create("/courses/${itemUpdated.id}")).build()
        } catch (e: Exception) {
            logger.info("create::catch: ${e.message}")
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun readByFilter(item: CourseModel): ResponseEntity<List<CourseModel>> {
        var filteredCourses: List<CourseModel>? = null

        return try {
            logger.info("readByFilter::item: $item")
            filteredCourses = courseService.read()
            logger.info("readByFilter::filteredCourses: $filteredCourses")
            ResponseEntity.ok(filteredCourses)

        } catch (e: Exception) {
            ResponseEntity(filteredCourses, HttpStatus.NOT_FOUND)
        }

    }

    override fun read(): ResponseEntity<List<CourseModel>> {
        val courseModelList = courseService.read()
        logger.info("read::courseModelList: $courseModelList")
        return ResponseEntity.ok(courseModelList)
    }

    override fun update(item: CourseModel, id: Long): ResponseEntity<CourseModel> {
        return try {
            logger.info("read::update: $item")
            courseService.update(item)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun delete(id: Long): ResponseEntity<Unit> {
        return try {
            courseService.delete(id)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }

    }
}