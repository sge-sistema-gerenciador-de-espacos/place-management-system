package com.pms.placemanagementsystemserverside.apicontroller.space

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.api.response.ApiResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.KeyResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.StatusResponseModel
import com.pms.placemanagementsystemserverside.models.enums.StatusResponseTypeEnum
import com.pms.placemanagementsystemserverside.models.space.ComputerLabModel
import com.pms.placemanagementsystemserverside.service.space.SpaceService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
        value = ["/pms-api/spaces/computer-lab"],
        consumes = ["application/json"],
        produces = ["application/json"]
)
class ComputerLabApiController : ApiController<ComputerLabModel> {

    private val logger = LoggerFactory.getLogger(SpaceApiController::class.java)

    @Autowired
    private lateinit var spaceService: SpaceService

    override fun create(item: ComputerLabModel): ApiResponseModel {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = spaceService.create(item)
            ApiResponseModel(
                    20000,
                    KeyResponseModel(itemUpdated.id)
            )
        } catch (e: Exception) {
            ApiResponseModel()
        }
    }

    override fun update(item: ComputerLabModel, id: Long): ApiResponseModel {
        return try {
            logger.info("read::update: $item")
            spaceService.update(item)
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseTypeEnum.SUCCESS.status)
            )
        } catch (e: Exception) {
            ApiResponseModel()
        }
    }

    /**
     * Using from SpaceApiController
     */
    override fun readByFilter(item: ComputerLabModel): ApiResponseModel {
        return ApiResponseModel()
    }

    /**
     * Using from SpaceApiController
     */
    override fun read(): ApiResponseModel {
        return ApiResponseModel()
    }

    /**
     * Using from SpaceApiController
     */
    override fun delete(id: Long): ApiResponseModel {
        return ApiResponseModel(
                20000,
                StatusResponseModel(StatusResponseTypeEnum.SUCCESS.status)
        )
    }

}