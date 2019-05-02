package com.pms.placemanagementsystemserverside.repository.clazz

import com.pms.placemanagementsystemserverside.models.clazz.ClazzModel
import org.springframework.data.jpa.repository.JpaRepository

interface ClazzJpaRepository : JpaRepository<ClazzModel, Long>
