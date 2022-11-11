package pl.dawtub.covid19stats.model.response

import java.time.LocalDate

data class DetailedDailyStatisticDto(
    val datestamp: LocalDate,
    val region: String,
    val infections: Int,
    val recovers: Int,
    val deathsAmount: Int,
    val deathsCovid: Int,
    val deathsCovidOther: Int,
    val testsAmount: Int,
    val testsPositive: Int,
    val testsNegative: Int,
    val testsOther: Int,
)
