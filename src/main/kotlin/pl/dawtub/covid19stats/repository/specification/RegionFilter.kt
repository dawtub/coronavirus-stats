package pl.dawtub.covid19stats.repository.specification

import org.springframework.data.jpa.domain.Specification
import pl.dawtub.covid19stats.model.Region
import pl.dawtub.covid19stats.model.Region_
import javax.persistence.criteria.Root

object RegionFilter {
    fun byName(name: String): Specification<Region> =
        Specification { root: Root<Region>, qb, cb ->
            qb.orderBy(cb.desc(root.get(Region_.name)))
            cb.equal(root.get(Region_.name), name.lowercase())
        }
}