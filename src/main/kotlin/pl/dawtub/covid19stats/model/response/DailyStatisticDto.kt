package pl.dawtub.covid19stats.model.response

import java.time.LocalDate

data class DailyStatisticDto(
    val datestamp: LocalDate,
    val infections: Long,
    val deaths: Int,
    val tests: Int,
)
