package pl.dawtub.covid19stats.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import pl.dawtub.covid19stats.model.Statistic

@Repository
interface StatisticRepository : JpaRepository<Statistic, Long>, JpaSpecificationExecutor<Statistic>
