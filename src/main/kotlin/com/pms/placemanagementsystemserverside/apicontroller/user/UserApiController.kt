package com.pms.placemanagementsystemserverside.apicontroller.user

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.api.authenticator.AuthenticatorRequestModel
import com.pms.placemanagementsystemserverside.models.api.authenticator.AuthenticatorResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.ApiResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.KeyResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.StatusResponseModel
import com.pms.placemanagementsystemserverside.models.user.UserModel
import com.pms.placemanagementsystemserverside.service.user.UserService
import com.pms.placemanagementsystemserverside.service.user.impl.UserServiceImpl
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/pms-api/user"])
class UserApiController : ApiController<UserModel> {

    private val logger = LoggerFactory.getLogger(UserApiController::class.java)

    @Autowired
    private lateinit var userService: UserService

    @ResponseBody
    override fun create(item: UserModel): ApiResponseModel {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = userService.create(item)
            val apiResponseModel = ApiResponseModel(20000, KeyResponseModel(itemUpdated.id ?: 0))
            logger.info("create::response::success: $apiResponseModel")
            apiResponseModel
        } catch (e: Exception) {
            logger.info("create::catch: ${e.message}")
            ApiResponseModel(HttpStatus.CONFLICT.value(), null)
        }
    }

    override fun readByFilter(item: UserModel): ApiResponseModel {
        var filteredUsers: List<UserModel>? = null

        return try {
            logger.info("readByFilter::item: $item")
            filteredUsers = userService.read()
            logger.info("readByFilter::filteredUsers: $filteredUsers")
//            ApiResponseModel(HttpStatus.OK.value(), filteredUsers)
            ApiResponseModel(20000, filteredUsers)
        } catch (e: Exception) {
            ApiResponseModel(HttpStatus.NOT_FOUND.value(), filteredUsers)
        }
    }

    override fun read(): ApiResponseModel {
        val userModelList = userService.read()
        logger.info("read::userModelList: $userModelList")
        return ApiResponseModel(20000, userModelList)
    }

    @GetMapping(value = ["/master"])
    fun readMaster(): ApiResponseModel {
        val userModelList = (userService as UserServiceImpl).readByUserType()
        logger.info("read::userModelList: $userModelList")
        return ApiResponseModel(20000, userModelList)
    }

    override fun update(item: UserModel, id: Long): ApiResponseModel {
        return try {
            logger.info("update::item: $item")
            //TODO acertar update para procurar pelo id
            userService.update(item)
//            ApiResponseModel(
//                    HttpStatus.NO_CONTENT.value(),
//                    PutResponseModel(PutResponseModel.PutResponseTypeEnum.SUCCESS)
//            )

            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseModel.StatusResponseTypeEnum.SUCCESS)
            )

        } catch (e: Exception) {
            ApiResponseModel(
                    HttpStatus.NO_CONTENT.value(),
                    StatusResponseModel(StatusResponseModel.StatusResponseTypeEnum.SUCCESS)
            )
        }
    }

    override fun delete(id: Long): ApiResponseModel {
        return try {
            logger.info("delete::id: $id")
            userService.delete(id)
            ApiResponseModel(
                    20000,
                    StatusResponseModel(StatusResponseModel.StatusResponseTypeEnum.SUCCESS)
            )

        } catch (e: Exception) {
            ApiResponseModel(
                    HttpStatus.NO_CONTENT.value(),
                    StatusResponseModel(StatusResponseModel.StatusResponseTypeEnum.ERROR)
            )
        }
    }

    //TODO rever
    @PostMapping(value = ["/login"])
    fun login(@RequestBody authenticatorRequestModel: AuthenticatorRequestModel):
            ApiResponseModel {
        logger.info("login::authenticatorRequestModel: $authenticatorRequestModel")
        return ApiResponseModel(
                20000,
                AuthenticatorResponseModel()
        )
    }

    //TODO rever
    @PostMapping(value = ["/logout"])
    fun logout(): ApiResponseModel {
        logger.info("logout")
        return ApiResponseModel(20000, "success")
    }

    //TODO rever / acertar o response
    @GetMapping(value = ["/info"])
    fun getInfo(@RequestParam token: String): String {
        logger.info("info")
        return "{\"code\":20000,\"data\":{\"roles\":[\"admin\"],\"introduction\":\"I am a super administrator\",\"avatar\":\"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\",\"name\":\"Super Admin\"}}"
    }

}