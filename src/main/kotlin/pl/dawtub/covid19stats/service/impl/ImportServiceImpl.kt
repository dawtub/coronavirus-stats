package pl.dawtub.covid19stats.service.impl

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import pl.dawtub.covid19stats.model.csv.StatisticCsv
import pl.dawtub.covid19stats.model.csv.StatisticRowCsv
import pl.dawtub.covid19stats.service.ImportService

@Service
internal class ImportServiceImpl : ImportService {
    override fun csvToStatistic(file: MultipartFile): StatisticCsv {
        val bootstrapSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';')
        val mapper = CsvMapper().registerModule(
            KotlinModule.Builder()
                .withReflectionCacheSize(512)
                .configure(KotlinFeature.NullToEmptyCollection, false)
                .configure(KotlinFeature.NullToEmptyMap, false)
                .configure(KotlinFeature.NullIsSameAsDefault, false)
                .configure(KotlinFeature.SingletonSupport, false)
                .configure(KotlinFeature.StrictNullChecks, false)
                .build()
        )

        val rows: MutableList<StatisticRowCsv> = mutableListOf()
        mapper.readerFor(StatisticRowCsv::class.java)
            .with(bootstrapSchema)
            .readValues<StatisticRowCsv>(file.inputStream)
            .forEach { rows.add(it) }

        return StatisticCsv(file.name, rows)
    }
}