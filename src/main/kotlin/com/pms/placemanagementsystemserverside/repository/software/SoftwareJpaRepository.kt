package com.pms.placemanagementsystemserverside.repository.software

import com.pms.placemanagementsystemserverside.models.space.software.SoftwareModel
import org.springframework.data.jpa.repository.JpaRepository

interface SoftwareJpaRepository : JpaRepository<SoftwareModel, Long>