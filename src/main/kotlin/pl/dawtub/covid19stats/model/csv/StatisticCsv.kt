package pl.dawtub.covid19stats.model.csv

data class StatisticCsv(
    val name: String,
    val rows: List<StatisticRowCsv>,
)
