package pl.dawtub.covid19stats.model.csv

import com.fasterxml.jackson.annotation.JsonProperty

data class StatisticRowCsv(
    @JsonProperty("stan_rekordu_na")
    val date: String,
    @JsonProperty("wojewodztwo")
    val region: String,
    @JsonProperty("teryt")
    val regionCode: String,
    @JsonProperty("liczba_na_10_tys_mieszkancow")
    val amountFor10: String,
    @JsonProperty("liczba_przypadkow")
    val infections: Int,
    @JsonProperty("zgony")
    val deaths: Int,
    @JsonProperty("zgony_w_wyniku_covid_bez_chorob_wspolistniejacych")
    val deathsCovid: Int,
    @JsonProperty("zgony_w_wyniku_covid_i_chorob_wspolistniejacych")
    val deathsCovidOther: Int,
    @JsonProperty("liczba_zlecen_poz")
    val pozOrders: Int,
    @JsonProperty("liczba_osob_objetych_kwarantanna")
    val quarantines: Int,
    @JsonProperty("liczba_wykonanych_testow")
    val tests: Int,
    @JsonProperty("liczba_testow_z_wynikiem_pozytywnym")
    val testsPositive: Int,
    @JsonProperty("liczba_testow_z_wynikiem_negatywnym")
    val testsNegative: Int,
    @JsonProperty("liczba_pozostalych_testow")
    val testsOther: Int,
    @JsonProperty("liczba_ozdrowiencow")
    val recovers: Int,
)
