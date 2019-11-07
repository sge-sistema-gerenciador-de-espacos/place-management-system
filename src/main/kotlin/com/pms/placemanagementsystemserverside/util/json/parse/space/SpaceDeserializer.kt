package com.pms.placemanagementsystemserverside.util.json.parse.space

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.node.IntNode
import com.pms.placemanagementsystemserverside.extensions.deserializeToActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.extensions.deserializeToSpaceEnumType
import com.pms.placemanagementsystemserverside.extensions.isComputerLab
import com.pms.placemanagementsystemserverside.extensions.trueOrFalse
import com.pms.placemanagementsystemserverside.models.space.ComputerLabModel
import com.pms.placemanagementsystemserverside.models.space.SpaceModel

class SpaceDeserializer(spaceModel: Class<SpaceModel>) : StdDeserializer<SpaceModel>(spaceModel) {
    override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): SpaceModel {
        val treeNode = jsonParser.readValueAsTree<TreeNode>()
        val id = (treeNode.get("id") as IntNode).numberValue().toLong()
        val name = treeNode.get("name").toString()
        val numberOfChairs = (treeNode.get("numberChair") as IntNode).numberValue().toInt()
        val hasProjector = (treeNode.get("project") as IntNode).numberValue().toInt().trueOrFalse()
        val hasBoard = (treeNode.get("board") as IntNode).numberValue().toInt().trueOrFalse()
        val hasSmartBoard = (treeNode.get("smartBoard") as IntNode).numberValue().toInt().trueOrFalse()
        val type = (treeNode.get("type") as IntNode).numberValue().toInt().deserializeToSpaceEnumType()
        val status = (treeNode.get("status") as IntNode).numberValue().toInt().deserializeToActivationModelStatusEnum()

        if (type.isComputerLab()) {
            val numberOfPcs = (treeNode.get("numberPc") as IntNode).numberValue().toInt()
            //TODO softwares ?
            return ComputerLabModel(
                    id, name, numberOfChairs, hasProjector, hasBoard, hasSmartBoard, type, status, numberOfPcs
            )
        } else {
            return SpaceModel(id, name, numberOfChairs, hasProjector, hasBoard, hasSmartBoard, type, status)
        }
    }
}