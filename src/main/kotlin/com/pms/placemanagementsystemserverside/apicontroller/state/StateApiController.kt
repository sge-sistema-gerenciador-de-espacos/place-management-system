package com.pms.placemanagementsystemserverside.apicontroller.state

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
        value = ["/pms-api/state"],
        consumes = ["application/json"],
        produces = ["application/json"]
)
class StateApiController {
    fun read(): String {
        return "[\n" +
                "    {\n" +
                "    code: 20000,\n" +
                "    data: [\n" +
                "    {\n" +
                "        ID: 1,\n" +
                "        Initials: 'AC',\n" +
                "        Name: 'Acre'\n" +
                "    },\n" +
                "      {\n" +
                "        ID: 2,\n" +
                "        Initials: 'AL',\n" +
                "        Name: 'Alagoas'\n" +
                "      },\n" +
                "  {\n" +
                "    ID: 3,\n" +
                "    Initials: 'AM',\n" +
                "    Name: 'Amazonas'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 4,\n" +
                "    Initials: 'AP',\n" +
                "    Name: 'Amapá'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 5,\n" +
                "    Initials: 'BA',\n" +
                "    Name: 'Bahia'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 6,\n" +
                "    Initials: 'CE',\n" +
                "    Name: 'Ceará'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 7,\n" +
                "    Initials: 'DF',\n" +
                "    Name: 'Distrito Federal'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 8,\n" +
                "    Initials: 'ES',\n" +
                "    Name: 'Espírito Santo'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 9,\n" +
                "    Initials: 'GO',\n" +
                "    Name: 'Goiás'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 10,\n" +
                "    Initials: 'MA',\n" +
                "    Name: 'Maranhão'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 11,\n" +
                "    Initials: 'MG',\n" +
                "    Name: 'Minas Gerais'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 12,\n" +
                "    Initials: 'MS',\n" +
                "    Name: 'Mato Grosso do Sul'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 13,\n" +
                "    Initials: 'MT',\n" +
                "    Name: 'Mato Grosso'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 14,\n" +
                "    Initials: 'PA',\n" +
                "    Name: 'Pará'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 15,\n" +
                "    Initials: 'PB',\n" +
                "    Name: 'Paraíba'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 16,\n" +
                "    Initials: 'PE',\n" +
                "    Name: 'Pernambuco'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 17,\n" +
                "    Initials: 'PI',\n" +
                "    Name: 'Piauí'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 18,\n" +
                "    Initials: 'PR',\n" +
                "    Name: 'Paraná'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 19,\n" +
                "    Initials: 'RJ',\n" +
                "    Name: 'Rio de Janeiro'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 20,\n" +
                "    Initials: 'RN',\n" +
                "    Name: 'Rio Grande do Norte'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 21,\n" +
                "    Initials: 'RO',\n" +
                "    Name: 'Rondônia'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 22,\n" +
                "    Initials: 'RR',\n" +
                "    Name: 'Roraima'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 23,\n" +
                "    Initials: 'RS',\n" +
                "    Name: 'Rio Grande do Sul'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 24,\n" +
                "    Initials: 'SC',\n" +
                "    Name: 'Santa Catarina'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 25,\n" +
                "    Initials: 'SE',\n" +
                "    Name: 'Sergipe'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 26,\n" +
                "    Initials: 'SP',\n" +
                "    Name: 'São Paulo'\n" +
                "  },\n" +
                "  {\n" +
                "    ID: 27,\n" +
                "    Initials: 'TO',\n" +
                "    Name: 'Tocantins'\n" +
                "  }\n" +
                "    ]\n" +
                "    }\n" +
                "]"
    }
}