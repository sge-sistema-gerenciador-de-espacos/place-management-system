package com.pms.placemanagementsystemserverside.config

import com.pms.placemanagementsystemserverside.domain.scheduling.SchedulingDomain
import com.pms.placemanagementsystemserverside.domain.scheduling.impl.SchedulingDomainImpl
import com.pms.placemanagementsystemserverside.domain.space.SpaceDomain
import com.pms.placemanagementsystemserverside.domain.space.impl.SpaceDomainImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringApplicationConfiguration {

    @Bean
    fun schedulingDomain(): SchedulingDomain = SchedulingDomainImpl()

    @Bean
    fun spaceDomain(): SpaceDomain = SpaceDomainImpl()

}