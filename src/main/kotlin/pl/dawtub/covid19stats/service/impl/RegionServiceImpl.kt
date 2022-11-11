package pl.dawtub.covid19stats.service.impl

import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import pl.dawtub.covid19stats.model.Region
import pl.dawtub.covid19stats.repository.RegionRepository
import pl.dawtub.covid19stats.service.RegionService

@Service
internal class RegionServiceImpl(
    private val regionRepository: RegionRepository
) : RegionService {
    override fun findAll(): Iterable<Region> =
        regionRepository.findAll(Sort.by(Sort.Direction.ASC, "name"))
}
