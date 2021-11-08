package pl.dawtub.covid19stats

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Covid19StatsApplication

fun main(args: Array<String>) {
    runApplication<Covid19StatsApplication>(*args)
}
