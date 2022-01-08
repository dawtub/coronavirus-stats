package pl.dawtub.covid19stats.model.request

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.DateTimeFormat.ISO
import java.time.LocalDate

data class StatisticQuery(
    val region: String?,
    @DateTimeFormat(iso = ISO.DATE)
    val startDate: LocalDate?,
    @DateTimeFormat(iso = ISO.DATE)
    val endDate: LocalDate?,
)
