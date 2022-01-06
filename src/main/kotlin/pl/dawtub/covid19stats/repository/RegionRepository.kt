package pl.dawtub.covid19stats.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import pl.dawtub.covid19stats.model.Region

@Repository
interface RegionRepository : CrudRepository<Region, Long> {
    fun findByName(name: String): Region
}