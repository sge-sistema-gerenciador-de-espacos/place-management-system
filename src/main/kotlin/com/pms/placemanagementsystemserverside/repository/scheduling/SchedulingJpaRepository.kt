package com.pms.placemanagementsystemserverside.repository.scheduling

import com.pms.placemanagementsystemserverside.models.scheduling.SchedulingModel
import org.springframework.data.jpa.repository.JpaRepository

interface SchedulingJpaRepository : JpaRepository<SchedulingModel, Long>