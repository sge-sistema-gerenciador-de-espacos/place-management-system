package com.pms.placemanagementsystemserverside.util.json.parse.user

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.pms.placemanagementsystemserverside.extensions.deserializeToActivationModelStatusEnum
import com.pms.placemanagementsystemserverside.extensions.deserializeToUserTypeEnum
import com.pms.placemanagementsystemserverside.models.user.UserModel


class UserDeserializer : StdDeserializer<UserModel> {

    constructor(userModel: Class<UserModel>?) : super(userModel)
    constructor() : this(null)

    override fun deserialize(jsonParser: JsonParser, context: DeserializationContext): UserModel {
        val jsonNode = jsonParser.codec.readTree<JsonNode>(jsonParser)

        val id = jsonNode.get("id").asLong()
        val type = jsonNode.get("type").asText().deserializeToUserTypeEnum()
        val email = jsonNode.get("email").asText()
        val status = jsonNode.get("status").asInt().deserializeToActivationModelStatusEnum()
        val name = jsonNode.get("name").asText()
        val street = jsonNode.get("street").asText()
        val neighborhood = jsonNode.get("neighborhood").asText()
        val city = jsonNode.get("city").asText()
        val number = jsonNode.get("number").asInt()
        val state = jsonNode.get("state").asInt()
        val telephone = jsonNode.get("telephone").asText()
        val password = jsonNode.get("password").asText()
        val application = jsonNode.get("application").asText()

        return UserModel(
                id = id, name = name, email = email, number = number, street = street,
                neighborhood = neighborhood, city = city, state = state, status = status,
                type = type, telephone = telephone, password = password, application = application
        )
    }
}