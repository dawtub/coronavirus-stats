package pl.dawtub.covid19stats.service

import pl.dawtub.covid19stats.model.Region

interface RegionService {
    fun findAll(): Iterable<Region>
}