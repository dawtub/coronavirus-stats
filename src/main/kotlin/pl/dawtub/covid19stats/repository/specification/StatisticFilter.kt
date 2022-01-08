package pl.dawtub.covid19stats.repository.specification

import org.springframework.data.jpa.domain.Specification
import pl.dawtub.covid19stats.model.Region
import pl.dawtub.covid19stats.model.Region_
import pl.dawtub.covid19stats.model.Statistic
import pl.dawtub.covid19stats.model.Statistic_
import pl.dawtub.covid19stats.model.request.StatisticQuery
import java.time.LocalDate
import javax.persistence.criteria.Join
import javax.persistence.criteria.Root

object StatisticFilter {
    fun withRegionName(name: String): Specification<Statistic> =
        Specification { root: Root<Statistic>, _, cb ->
            val join: Join<Statistic, Region> = root.join("region")
            cb.equal(join.get(Region_.name), name.lowercase())
        }

    fun isInDateRange(startDate: LocalDate, endDate: LocalDate): Specification<Statistic> =
        Specification { root: Root<Statistic>, _, cb ->
            cb.between(root.get(Statistic_.datestamp), startDate, endDate)
        }

    fun withQuery(query: StatisticQuery): Specification<Statistic> =
        Specification { root: Root<Statistic>, _, cb ->
            var conditions = cb.conjunction()
            if (!query.region.isNullOrEmpty()) {
                val join: Join<Statistic, Region> = root.join("region")
                conditions = cb.and(conditions, cb.equal(join.get(Region_.name), query.region))
            }

            if (!query.startDate.isNullOrEmpty())
                conditions = cb.and(
                    conditions, cb.greaterThanOrEqualTo(root.get(Statistic_.datestamp), LocalDate.parse(query.startDate))
                )

            if (!query.endDate.isNullOrEmpty())
                conditions = cb.and(
                    conditions, cb.lessThanOrEqualTo(root.get(Statistic_.datestamp), LocalDate.parse(query.endDate))
                )

            cb.and(conditions)
        }
}