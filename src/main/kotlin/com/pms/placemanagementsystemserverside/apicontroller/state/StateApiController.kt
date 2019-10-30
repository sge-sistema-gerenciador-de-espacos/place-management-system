package com.pms.placemanagementsystemserverside.apicontroller.state

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/pms-api/state"])
class StateApiController {

    @GetMapping
    fun read(): String {
        return """{"code":20000,"data":[
            |{"ID":1,"Initials":"AC","Name":"Acre"},
            |{"ID":2,"Initials":"AL","Name":"Alagoas"},
            |{"ID":3,"Initials":"AM","Name":"Amazonas"},
            |{"ID":4,"Initials":"AP","Name":"Amapá"},
            |{"ID":5,"Initials":"BA","Name":"Bahia"},
            |{"ID":6,"Initials":"CE","Name":"Ceará"},
            |{"ID":7,"Initials":"DF","Name":"Distrito Federal"},
            |{"ID":8,"Initials":"ES","Name":"Espírito Santo"},
            |{"ID":9,"Initials":"GO","Name":"Goiás"},
            |{"ID":10,"Initials":"MA","Name":"Maranhão"},
            |{"ID":11,"Initials":"MG","Name":"Minas Gerais"},
            |{"ID":12,"Initials":"MS","Name":"Mato Grosso do Sul"},
            |{"ID":13,"Initials":"MT","Name":"Mato Grosso"},
            |{"ID":14,"Initials":"PA","Name":"Pará"},
            |{"ID":15,"Initials":"PB","Name":"Paraíba"},
            |{"ID":16,"Initials":"PE","Name":"Pernambuco"},
            |{"ID":17,"Initials":"PI","Name":"Piauí"},
            |{"ID":18,"Initials":"PR","Name":"Paraná"},
            |{"ID":19,"Initials":"RJ","Name":"Rio de Janeiro"},
            |{"ID":20,"Initials":"RN","Name":"Rio Grande do Norte"},
            |{"ID":21,"Initials":"RO","Name":"Rondônia"},
            |{"ID":22,"Initials":"RR","Name":"Roraima"},
            |{"ID":23,"Initials":"RS","Name":"Rio Grande do Sul"},
            |{"ID":24,"Initials":"SC","Name":"Santa Catarina"},
            |{"ID":25,"Initials":"SE","Name":"Sergipe"},
            |{"ID":26,"Initials":"SP","Name":"São Paulo"},
            |{"ID":27,"Initials":"TO","Name":"Tocantins"}]}""".trimMargin()
    }

}