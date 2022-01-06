package pl.dawtub.covid19stats.model

import javax.persistence.*

@Entity
@Table
data class Region(
    val name: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}
