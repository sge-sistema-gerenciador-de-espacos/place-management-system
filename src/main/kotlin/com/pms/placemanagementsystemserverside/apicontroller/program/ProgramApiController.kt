package com.pms.placemanagementsystemserverside.apicontroller.program

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.api.response.ApiResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.KeyResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.StatusResponseModel
import com.pms.placemanagementsystemserverside.models.program.ProgramModel
import com.pms.placemanagementsystemserverside.service.program.ProgramService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

    override fun create(item: ProgramModel): ApiResponseModel {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = programService.create(item)
            ApiResponseModel(20000, KeyResponseModel(itemUpdated.id))
        } catch (e: Exception) {
            logger.info("create::catch: ${e.message}")
            ApiResponseModel()
        }
    }

    override fun readByFilter(item: ProgramModel): ApiResponseModel {
        var filteredPrograms: List<ProgramModel>?

        return try {
            logger.info("readByFilter::item: $item")
            filteredPrograms = programService.read()
            logger.info("readByFilter::filteredPrograms: $filteredPrograms")
            ApiResponseModel()

        } catch (e: Exception) {
            ApiResponseModel()
        }

    }

    override fun read(): ApiResponseModel {
        val programModelList = programService.read()
        logger.info("read::programModelList: $programModelList")
        return ApiResponseModel(20000, programModelList)
    }

    override fun update(item: ProgramModel, id: Long): ApiResponseModel {
        return try {
            logger.info("read::update: $item")
            programService.update(item)
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseModel.StatusResponseTypeEnum.SUCCESS)
            )
        } catch (e: Exception) {
            ApiResponseModel()
        }
    }

    override fun delete(id: Long): ApiResponseModel {
        return try {
            programService.delete(id)
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseModel.StatusResponseTypeEnum.SUCCESS)
            )
        } catch (e: Exception) {
            ApiResponseModel()
        }

    }
}