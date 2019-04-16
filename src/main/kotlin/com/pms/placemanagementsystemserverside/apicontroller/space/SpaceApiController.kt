package com.pms.placemanagementsystemserverside.apicontroller.space

import com.pms.placemanagementsystemserverside.apicontroller.BaseApiController
import com.pms.placemanagementsystemserverside.models.ComputerLabModel
import com.pms.placemanagementsystemserverside.models.SoftwareModel
import com.pms.placemanagementsystemserverside.models.SpaceModel
import com.pms.placemanagementsystemserverside.models.enums.TypeOfSpaceEnum
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI


@RestController
@RequestMapping(value = ["/spaces"])
class SpaceApiController : BaseApiController<SpaceModel>() {

    @PostMapping
    override fun post(item: SpaceModel): ResponseEntity<SpaceModel> {
        getSpaces().add(item)
        return ResponseEntity.created(URI.create("/spaces")).build()
    }

    @GetMapping
    override fun get(item: SpaceModel): ResponseEntity<List<SpaceModel>> {
        return ResponseEntity(getSpaces(), HttpStatus.OK)
    }

    @PutMapping
    override fun put(item: SpaceModel): ResponseEntity<SpaceModel> {
        getSpaces().apply {
            removeIf { it.id == item.id }
            add(item)
        }
        return ResponseEntity.accepted().build()
    }

    @DeleteMapping
    override fun delete(item: SpaceModel): ResponseEntity<SpaceModel> {
        return ResponseEntity.accepted().build()
    }

    private fun getSpaces(): MutableList<SpaceModel> {

        val spaceModel = SpaceModel(id = 1L, name = "SalaA", numberOfChairs = 12, hasProjector = true,
                hasBoard = true, hasSmartBoard = false, typeOfSpace = TypeOfSpaceEnum.CLASSROOM)

        val sparceModel = ComputerLabModel(id = 1L, name = "SalaA", numberOfChairs = 12, hasProjector = true,
                hasBoard = true, hasSmartBoard = false, numberOfPcs = 20, softwares = getSoftwares())

        return mutableListOf(spaceModel)
    }

    private fun getSoftwares(): MutableList<SoftwareModel> =
            mutableListOf(
                    SoftwareModel(id = 1L, name = "Intellij"),
                    SoftwareModel(id = 2L, name = "AndroidStudio")
            )
}