package pl.dawtub.covid19stats.model.request

data class StatisticQuery(
    val region: String?,
    val startDate: String?,
    val endDate: String?,
)
