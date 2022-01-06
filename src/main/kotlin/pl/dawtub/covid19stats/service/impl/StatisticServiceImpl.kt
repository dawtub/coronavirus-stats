package pl.dawtub.covid19stats.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import pl.dawtub.covid19stats.model.Death
import pl.dawtub.covid19stats.model.Statistic
import pl.dawtub.covid19stats.model.Test
import pl.dawtub.covid19stats.model.request.StatisticQuery
import pl.dawtub.covid19stats.repository.DeathRepository
import pl.dawtub.covid19stats.repository.RegionRepository
import pl.dawtub.covid19stats.repository.StatisticRepository
import pl.dawtub.covid19stats.repository.TestRepository
import pl.dawtub.covid19stats.repository.specification.StatisticFilter.withQuery
import pl.dawtub.covid19stats.repository.specification.StatisticFilter.withRegionName
import pl.dawtub.covid19stats.service.ImportService
import pl.dawtub.covid19stats.service.StatisticService
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
internal class StatisticServiceImpl(
    val statisticRepository: StatisticRepository,
    val regionRepository: RegionRepository,
    val deathRepository: DeathRepository,
    val testRepository: TestRepository,
    val importService: ImportService
) : StatisticService {
    override fun findAll(): List<Statistic> {
        return statisticRepository.findAll(withRegionName("cały kraj"))
    }

    override fun findAllWithQuery(query: StatisticQuery): List<Statistic> {
        return statisticRepository
            .findAll(withQuery(query))
    }

    override fun findOne(id: Long): Statistic? {
        return statisticRepository.findByIdOrNull(id)
    }

    override fun save(csvFile: MultipartFile) {
        importService.csvToStatistic(csvFile).rows.forEach {
            statisticRepository.save(
                Statistic(
                    LocalDate.parse(it.date, DateTimeFormatter.ISO_DATE),
                    it.infections,
                    deathRepository.save(
                        Death(
                            it.deaths,
                            it.deathsCovid,
                            it.deathsCovidOther
                        )
                    ),
                    testRepository.save(
                        Test(
                            it.tests,
                            it.testsPositive,
                            it.testsNegative,
                            it.testsOther
                        )
                    ),
                    regionRepository.findByName(it.region.lowercase()),
                )
            )
        }
    }
}