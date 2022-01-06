package pl.dawtub.covid19stats.model

import javax.persistence.*

@Entity
@Table
data class Test(
    @Column
    val testAmount: Int,

    @Column
    val testPositives: Int,

    @Column
    val testNegatives: Int,

    @Column
    val testOther: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}
