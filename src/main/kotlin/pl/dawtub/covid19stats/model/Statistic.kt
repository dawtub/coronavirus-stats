package pl.dawtub.covid19stats.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table
data class Statistic(
    @Column
    val datestamp: LocalDate,

    @Column
    val infections: Int,

    @Column
    val healths: Int,

    @OneToOne
    @JoinColumn(name = "deathsId")
    val deaths: Death,

    @OneToOne
    @JoinColumn(name = "testsId")
    val tests: Test,

    @ManyToOne
    @JoinColumn(name = "regionId")
    val region: Region,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}
