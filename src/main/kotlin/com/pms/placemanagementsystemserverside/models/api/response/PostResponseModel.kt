package com.pms.placemanagementsystemserverside.models.api.response

import com.fasterxml.jackson.annotation.JsonProperty

data class PostResponseModel(
        @JsonProperty(value = "key")
        private val id: Long
)