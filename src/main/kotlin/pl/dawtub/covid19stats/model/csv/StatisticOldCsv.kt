package pl.dawtub.covid19stats.model.csv

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class StatisticOldCsv (
    @JsonProperty("Data")
    val date: LocalDate,
    @JsonProperty("Nowe przypadki")
    val infections: Long,
    @JsonProperty("Wszystkie przypadki kumulatywnie")
    val infectionsOverall: Long,
    @JsonProperty("Zgony")
    val deaths: Long,
    @JsonProperty("Wszystkie zgony kumulatywnie")
    val deathsOverall: Long,
    @JsonProperty("Ozdrowieńcy (dzienna)")
    val health: Long,
    @JsonProperty("Ozdrowieńcy (suma)")
    val healthOverall: Long,
    @JsonProperty("Aktywne przypadki")
    val activeCovidians: Long,
    @JsonProperty("Kwarantanna")
    val quarantine: Long,
    @JsonProperty("Nadzór")
    val overwatch: Long,
)