package com.pms.placemanagementsystemserverside.apicontroller.course

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.api.response.ApiResponseModel
import com.pms.placemanagementsystemserverside.models.course.CourseModel
import com.pms.placemanagementsystemserverside.service.course.CourseService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

    override fun create(item: CourseModel): ApiResponseModel {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = courseService.create(item)
            ApiResponseModel()
        } catch (e: Exception) {
            logger.info("create::catch: ${e.message}")
            ApiResponseModel()
        }
    }

    override fun readByFilter(item: CourseModel): ApiResponseModel {
        var filteredCourses: List<CourseModel>? = null

        return try {
            logger.info("readByFilter::item: $item")
            filteredCourses = courseService.read()
            logger.info("readByFilter::filteredCourses: $filteredCourses")
            ApiResponseModel()

        } catch (e: Exception) {
            ApiResponseModel()
        }

    }

    override fun read(): ApiResponseModel {
        val courseModelList = courseService.read()
        logger.info("read::courseModelList: $courseModelList")
        return ApiResponseModel()
    }

    override fun update(item: CourseModel, id: Long): ApiResponseModel {
        return try {
            logger.info("read::update: $item")
            courseService.update(item)
            ApiResponseModel()
        } catch (e: Exception) {
            ApiResponseModel()
        }
    }

    override fun delete(id: Long): ApiResponseModel {
        return try {
            courseService.delete(id)
            ApiResponseModel()
        } catch (e: Exception) {
            ApiResponseModel()
        }

    }
}