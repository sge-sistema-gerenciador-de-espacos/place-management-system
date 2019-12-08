package com.pms.placemanagementsystemserverside.apicontroller.space

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.dto.SpaceSoftwareDto
import com.pms.placemanagementsystemserverside.models.api.response.ApiResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.KeyResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.StatusResponseModel
import com.pms.placemanagementsystemserverside.models.enums.StatusResponseTypeEnum
import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import com.pms.placemanagementsystemserverside.service.space.SpaceService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/pms-api/space"])
class SpaceApiController : ApiController<SpaceModel> {

    private val logger = LoggerFactory.getLogger(SpaceApiController::class.java)

    @Autowired
    private lateinit var spaceService: SpaceService

    override fun create(item: SpaceModel): ApiResponseModel {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = spaceService.create(item)
            ApiResponseModel(
                    20000,
                    KeyResponseModel(itemUpdated.id)
            )
        } catch (e: Exception) {
            logger.info("create::catch: ${e.message}")
            ApiResponseModel()
        }
    }

    override fun readByFilter(item: SpaceModel): ApiResponseModel {
        val filteredSpaces: List<SpaceModel>?

        return try {
            logger.info("readByFilter::item: $item")
            filteredSpaces = spaceService.read()
            logger.info("readByFilter::filteredSpaces: $filteredSpaces")
            ApiResponseModel()

        } catch (e: Exception) {
            ApiResponseModel()
        }

    }

    override fun read(): ApiResponseModel {
        val spaceModelList = spaceService.read()
        logger.info("read::spaceModelList: $spaceModelList")
        return ApiResponseModel(20000, spaceModelList)
    }

    @GetMapping(value = ["/{spaceId}/software"])
    fun readSoftwareBySpaceId(@PathVariable spaceId: Long): ApiResponseModel {
        val softwareModelFilteredBySpaceList = spaceService.readSoftwareBySpaceId(spaceId)
        logger.info("readActive::softwareModelFilteredBySpaceList: $softwareModelFilteredBySpaceList")
        return ApiResponseModel(20000, softwareModelFilteredBySpaceList)
    }

    override fun update(item: SpaceModel, id: Long): ApiResponseModel {
        return try {
            item.id = id
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

    override fun delete(id: Long): ApiResponseModel {
        return try {
            spaceService.delete(id)
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseTypeEnum.SUCCESS.status)
            )
        } catch (e: Exception) {
            ApiResponseModel()
        }
    }

    @DeleteMapping(value = ["/{spaceId}/software/{softwareId}"])
    fun deleteSoftwareOfSpace(@PathVariable spaceId: Long, @PathVariable softwareId: Long): ApiResponseModel {
        return try {
            spaceService.deleteSoftwareOfSpace(SpaceSoftwareDto(spaceId = spaceId, softwareId = softwareId))
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseTypeEnum.SUCCESS.status)
            )
        } catch (e: Exception) {
            ApiResponseModel(
                    0,
                    StatusResponseModel(StatusResponseTypeEnum.ERROR.status)
            )
        }
    }

    @PostMapping(value = ["/space/software"])
    fun deleteSoftwareOfSpace(@RequestBody spaceSoftwareDto: SpaceSoftwareDto): ApiResponseModel {
        return try {
            spaceService.addSoftwareOfSpace(spaceSoftwareDto)
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseTypeEnum.SUCCESS.status)
            )
        } catch (e: Exception) {
            ApiResponseModel(
                    0,
                    StatusResponseModel(StatusResponseTypeEnum.ERROR.status)
            )
        }
    }

}