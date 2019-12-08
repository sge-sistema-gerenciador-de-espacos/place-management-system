package com.pms.placemanagementsystemserverside.apicontroller.software

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.api.response.ApiResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.KeyResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.StatusResponseModel
import com.pms.placemanagementsystemserverside.models.enums.StatusResponseTypeEnum
import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel
import com.pms.placemanagementsystemserverside.service.software.SoftwareService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/pms-api/software"])
class SoftwareApiController : ApiController<SoftwareModel> {

    private val logger = LoggerFactory.getLogger(SoftwareApiController::class.java)

    @Autowired
    private lateinit var softwareService: SoftwareService

    override fun create(item: SoftwareModel): ApiResponseModel {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = softwareService.create(item)
            ApiResponseModel(20000, KeyResponseModel(itemUpdated.id))
        } catch (e: Exception) {
            ApiResponseModel()
        }
    }

    override fun readByFilter(item: SoftwareModel): ApiResponseModel {
        var filteredSoftwares: List<SoftwareModel>?

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
        return ApiResponseModel(20000, softwareModelList)
    }

    @GetMapping(value = ["/enable"])
    fun readActive(): ApiResponseModel {
        val softwareModelActiveList = softwareService.readActive()
        logger.info("readActive::softwareModelActiveList: $softwareModelActiveList")
        return ApiResponseModel(20000, softwareModelActiveList)
    }

    override fun update(item: SoftwareModel, id: Long): ApiResponseModel {
        return try {
            item.id = id
            logger.info("read::update: $item")
            softwareService.update(item)
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseTypeEnum.SUCCESS.status)
            )
        } catch (e: Exception) {
            ApiResponseModel()
        }
    }

    override fun delete(id: Long): ApiResponseModel {
        return try {
            softwareService.delete(id)
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseTypeEnum.SUCCESS.status)
            )
        } catch (e: Exception) {
            ApiResponseModel()
        }

    }

}