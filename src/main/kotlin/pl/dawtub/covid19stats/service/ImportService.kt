package pl.dawtub.covid19stats.service

import org.springframework.web.multipart.MultipartFile
import pl.dawtub.covid19stats.model.csv.StatisticCsv

interface ImportService {
    fun csvToStatistic(file: MultipartFile): StatisticCsv
}