package com.pms.placemanagementsystemserverside.repository.user

import com.pms.placemanagementsystemserverside.models.user.UserModel
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<UserModel, Long>
