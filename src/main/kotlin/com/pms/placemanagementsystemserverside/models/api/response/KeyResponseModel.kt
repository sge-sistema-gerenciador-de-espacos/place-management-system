package com.pms.placemanagementsystemserverside.models.api.response

import com.fasterxml.jackson.annotation.JsonProperty

data class KeyResponseModel(
        @JsonProperty(value = "key")
        private val id: Long
)