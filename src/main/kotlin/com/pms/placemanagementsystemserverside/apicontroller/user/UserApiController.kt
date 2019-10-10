package com.pms.placemanagementsystemserverside.apicontroller.user

import com.pms.placemanagementsystemserverside.apicontroller.contract.ApiController
import com.pms.placemanagementsystemserverside.models.api.authenticator.AuthenticatorRequestModel
import com.pms.placemanagementsystemserverside.models.api.authenticator.AuthenticatorResponseModel
import com.pms.placemanagementsystemserverside.models.api.response.ApiResponseModel
import com.pms.placemanagementsystemserverside.models.user.UserModel
import com.pms.placemanagementsystemserverside.service.user.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = ["/pms-api/user"])
class UserApiController : ApiController<UserModel> {

    private val logger = LoggerFactory.getLogger(UserApiController::class.java)

    @Autowired
    private lateinit var userService: UserService

    override fun create(item: UserModel): ResponseEntity<Unit> {
        return try {
            logger.info("create::item: $item")
            val itemUpdated = userService.create(item)
            ResponseEntity.created(URI.create("/users/${itemUpdated.id}")).build()
        } catch (e: Exception) {
            logger.info("create::catch: ${e.message}")
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    override fun readByFilter(item: UserModel): ResponseEntity<List<UserModel>> {
        var filteredUsers: List<UserModel>? = null

        return try {
            logger.info("readByFilter::item: $item")
            filteredUsers = userService.read()
            logger.info("readByFilter::filteredUsers: $filteredUsers")
            ResponseEntity.ok(filteredUsers)

        } catch (e: Exception) {
            ResponseEntity(filteredUsers, HttpStatus.NOT_FOUND)
        }

    }

    override fun read(): ResponseEntity<List<UserModel>> {
        val userModelList = userService.read()
//        val userModelList = getUsers()
        logger.info("read::userModelList: $userModelList")
        return ResponseEntity.ok(userModelList)
    }

    override fun update(item: UserModel, id: Long): ResponseEntity<UserModel> {
        return try {
            logger.info("update::item: $item")
            userService.update(item)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun delete(id: Long): ResponseEntity<Unit> {
        return try {
            logger.info("delete::id: $id")
            userService.delete(id)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    //TODO rever
    @PostMapping(value = ["/login"])
    fun login(@RequestBody authenticatorRequestModel: AuthenticatorRequestModel):
            ResponseEntity<ApiResponseModel> {
        logger.info("login::authenticatorRequestModel: $authenticatorRequestModel")
        return ResponseEntity.ok(
                ApiResponseModel(
                        20000,
                        AuthenticatorResponseModel()
                )
        )
    }

    @PostMapping(value = ["/logout"])
    fun logout(@RequestBody authenticatorRequestModel: AuthenticatorRequestModel):
            ResponseEntity<AuthenticatorResponseModel> {
        logger.info("logout::authenticatorRequestModel: $authenticatorRequestModel")
        return ResponseEntity.ok(AuthenticatorResponseModel())
    }

    //TODO rever
    @GetMapping(value = ["/info"])
    fun getInfo(@RequestParam token: String): ResponseEntity<String> {
        logger.info("info")
        return ResponseEntity.ok(
                "{\"code\":20000,\"data\":{\"roles\":[\"admin\"],\"introduction\":\"I am a super administrator\",\"avatar\":\"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\",\"name\":\"Super Admin\"}}"
        )
    }

    private fun getUsers(): List<UserModel> {
        return mutableListOf(UserModel(), UserModel(), UserModel())
    }
}