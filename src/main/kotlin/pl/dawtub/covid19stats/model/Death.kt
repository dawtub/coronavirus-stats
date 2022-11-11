package pl.dawtub.covid19stats.model

import javax.persistence.*

@Entity
@Table
data class Death(
    @Column
    val deathAmount: Int,

    @Column
    val deathCovidOnly: Int,

    @Column
    val deathCovidOther: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}
