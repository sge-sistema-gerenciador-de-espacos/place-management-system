package com.pms.placemanagementsystemserverside.repository.program

import com.pms.placemanagementsystemserverside.models.program.ProgramModel
import org.springframework.data.jpa.repository.JpaRepository

interface ProgramJpaRepository : JpaRepository<ProgramModel, Long>
