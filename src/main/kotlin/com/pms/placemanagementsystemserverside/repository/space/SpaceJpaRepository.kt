package com.pms.placemanagementsystemserverside.repository.space

import com.pms.placemanagementsystemserverside.models.space.SpaceModel
import org.springframework.data.jpa.repository.JpaRepository

interface SpaceJpaRepository : JpaRepository<SpaceModel, Long>