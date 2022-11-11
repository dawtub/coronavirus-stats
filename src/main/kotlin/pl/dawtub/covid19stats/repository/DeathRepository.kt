package pl.dawtub.covid19stats.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import pl.dawtub.covid19stats.model.Death

@Repository
interface DeathRepository : CrudRepository<Death, Long>
