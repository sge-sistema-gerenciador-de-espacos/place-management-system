package com.pms.placemanagementsystemserverside.apicontroller.software

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.api.response.ApiResponseModel
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel
import com.pms.placemanagementsystemserverside.service.software.SoftwareService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

    override fun create(item: SoftwareModel): ApiResponseModel {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = softwareService.create(item)
            ApiResponseModel()
        } catch (e: Exception) {
            ApiResponseModel()
        }
    }

    override fun readByFilter(item: SoftwareModel): ApiResponseModel {
        var filteredSoftwares: List<SoftwareModel>? = null

        return try {
            logger.info("readByFilter::item: $item")
            filteredSoftwares = softwareService.read()
            logger.info("readByFilter::filteredSoftwares: $filteredSoftwares")
            ApiResponseModel()

        } catch (e: Exception) {
            ApiResponseModel()
        }

    }

    override fun read(): ApiResponseModel {
        val softwareModelList = softwareService.read()
        logger.info("read::softwareModelList: $softwareModelList")
        return ApiResponseModel()
    }

    override fun update(item: SoftwareModel, id: Long): ApiResponseModel {
        return try {
            logger.info("read::update: $item")
            softwareService.update(item)
            ApiResponseModel()
        } catch (e: Exception) {
            ApiResponseModel()
        }
    }

    override fun delete(id: Long): ApiResponseModel {
        return try {
            softwareService.delete(id)
            ApiResponseModel()
        } catch (e: Exception) {
            ApiResponseModel()
        }

    }

}