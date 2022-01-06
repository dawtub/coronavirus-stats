package pl.dawtub.covid19stats.service

import org.springframework.web.multipart.MultipartFile
import pl.dawtub.covid19stats.model.Statistic
import pl.dawtub.covid19stats.model.request.StatisticQuery

interface StatisticService {
    fun findAll(): List<Statistic>
    fun findAllWithQuery(query: StatisticQuery): List<Statistic>
    fun findOne(id: Long): Statistic?
    fun save(csvFile: MultipartFile)
}