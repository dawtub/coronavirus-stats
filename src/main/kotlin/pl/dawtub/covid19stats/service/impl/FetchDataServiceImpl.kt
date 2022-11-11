package pl.dawtub.covid19stats.service.impl

import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import pl.dawtub.covid19stats.service.FetchDataService

@Component
class FetchDataServiceImpl : FetchDataService {
    @Scheduled(cron = "0 40 8 * * *", zone = "Europe/Warsaw")
    override fun fetch() {
        RestTemplate().exchange(
            "http://fetcher:8081/", HttpMethod.POST, HttpEntity.EMPTY, String::class.java
        )
    }
}
