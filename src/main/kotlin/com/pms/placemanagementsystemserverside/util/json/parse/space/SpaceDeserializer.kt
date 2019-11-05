package com.pms.placemanagementsystemserverside.util.json.parse.space

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.node.IntNode
import com.pms.placemanagementsystemserverside.extensions.trueOrFalse
import com.pms.placemanagementsystemserverside.models.enums.SpaceTypeEnum
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

class SpaceDeserializer(spaceModel: Class<SpaceModel>) : StdDeserializer<SpaceModel>(spaceModel) {
    override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): SpaceModel {
        val treeNode = jsonParser.readValueAsTree<TreeNode>()
        val id = (treeNode.get("id") as IntNode).numberValue() as Int
        val name = treeNode.get("name").toString()
        val numberOfChairs = (treeNode.get("numberChair") as IntNode).numberValue()
        val hasProjector = (treeNode.get("project") as IntNode).numberValue().toInt().trueOrFalse()
        val hasBoard = (treeNode.get("board") as IntNode).numberValue().toInt().trueOrFalse()
        val hasSmartBoard = (treeNode.get("smartBoard") as IntNode).numberValue().toInt().trueOrFalse()
        val status = treeNode.get("status")

        val type = treeNode.get("type").let {
            if (it.toString() == "sala") SpaceTypeEnum.CLASSROOM
            else SpaceTypeEnum.COMPUTER_LAB
        }



//                @Column(name = "number_chair")
//                @JsonProperty(value = "numberChair")
//                open var numberOfChairs: Int = 0,
//
//        @Column(name = "projector")
//        @JsonProperty(value = "project")
//        open var hasProjector: Boolean = false,
//
//        @Column(name = "board")
//        @JsonProperty(value = "board")
//        open var hasBoard: Boolean = false,
//
//        @Column(name = "smart_board")
//        @JsonProperty(value = "smartBoard")
//        open var hasSmartBoard: Boolean = false,
//
//        val type: SpaceTypeEnum = SpaceTypeEnum.CLASSROOM,
//
//        @OneToMany(targetEntity = SchedulingModel::class)
//        @JsonIgnoreProperties
//        val schedulingModels: MutableList<SchedulingModel> = mutableListOf(),
//
//        var status: ActivationModelStatusEnum = ActivationModelStatusEnum.UNKNOWN


        return SpaceModel()
    }
}