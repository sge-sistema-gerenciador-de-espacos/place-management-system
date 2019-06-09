package com.pms.placemanagementsystemserverside.util.json.parse.user

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.pms.placemanagementsystemserverside.models.user.UserModel
import java.io.IOException

class UserSerializer @JvmOverloads constructor(t: Class<UserModel>? = null) : StdSerializer<UserModel>(t) {

    @Throws(IOException::class, JsonProcessingException::class)
    override fun serialize(
            value: UserModel, jgen: JsonGenerator, provider: SerializerProvider) {

        jgen.writeStartObject()
//        jgen.writeStringField("client_id", value.getClientId())
//        jgen.writeStringField("purchase_id", value.getPurchaseId())
//        jgen.writeNumberField("value", value.getTotalToPay())
//        jgen.writeStringField("date", value.getDate())
//        jgen.writeStringField("card_number", value.getCreditCard().getCardNumber())
        jgen.writeEndObject()
    }

    companion object {

        /**
         *
         */
        private val serialVersionUID = -6897449863023614642L
    }

}