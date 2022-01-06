package pl.dawtub.covid19stats.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import pl.dawtub.covid19stats.model.request.StatisticQuery
import pl.dawtub.covid19stats.model.response.DailyStatisticDto
import pl.dawtub.covid19stats.model.response.DetailedDailyStatisticDto
import pl.dawtub.covid19stats.service.StatisticService

@RequestMapping("/stats")
@RestController
internal class StatisticController(
    private val statisticService: StatisticService
) {
    @GetMapping
    fun getAllStats(): List<DailyStatisticDto> =
        statisticService
            .findAll()
            .map {
                DailyStatisticDto(
                    it.datestamp,
                    it.infections,
                    it.deaths.deathAmount,
                    it.tests.testAmount
                )
            }
            .toList()

    @GetMapping("/search")
    fun getFilteredStatistics(
        @RequestParam query: StatisticQuery
    ): List<DetailedDailyStatisticDto> =
        statisticService
            .findAllWithQuery(query)
            .map {
                DetailedDailyStatisticDto(
                    it.datestamp,
                    it.region.name,
                    it.infections,
                    it.deaths.deathAmount,
                    it.deaths.deathCovidOnly,
                    it.deaths.deathCovidOther,
                    it.tests.testAmount,
                    it.tests.testPositives,
                    it.tests.testNegatives,
                    it.tests.testOther
                )
            }
            .toList()

    @PostMapping
    fun addStats(@RequestPart(value = "file") csvFile: MultipartFile) = statisticService.save(csvFile)
}
