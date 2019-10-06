package com.pms.placemanagementsystemserverside.util.json.parse.user

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.pms.placemanagementsystemserverside.models.user.UserModel


class UserDeserializer(userModel: Class<UserModel>) : StdDeserializer<UserModel>(userModel) {
    override fun deserialize(jsonParser: JsonParser, context: DeserializationContext): UserModel {
        val treeNode = jsonParser.readValueAsTree<TreeNode>()

//        return UserModel(
//                treeNode.get()
//        )
//
//        val id = (node.get("id") as IntNode).numberValue() as Int
//        val itemName = node.get("itemName").asText()
//        val userId = (node.get("createdBy") as IntNode).numberValue() as Int

        return UserModel()
    }
}