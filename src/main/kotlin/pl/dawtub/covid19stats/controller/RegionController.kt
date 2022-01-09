package pl.dawtub.covid19stats.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pl.dawtub.covid19stats.model.response.RegionDto
import pl.dawtub.covid19stats.service.RegionService

@RequestMapping("/regions")
@RestController
class RegionController(
    private val regionService: RegionService
) {
    @GetMapping
    fun getAll(): List<RegionDto> =
        regionService
            .findAll()
            .map {
                RegionDto(
                    it.name
                )
            }
            .toList()
}
