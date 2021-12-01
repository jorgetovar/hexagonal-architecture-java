package io.simplify.infra.adapter

import io.simplify.core.roadmaps.domain.Roadmap
import io.simplify.core.roadmaps.domain.Step
import io.simplify.core.roadmaps.port.`in`.RoadmapsClassifier
import io.simplify.core.roadmaps.port.out.RoadmapsRepository
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class RoadmapsHttpAdapter(val roadmapsClassified: RoadmapsClassified) {

    @GetMapping("/mandatory")
    fun mandatory(): List<Roadmap> = roadmapsClassified.mandatory()

    @GetMapping("/optional")
    fun optional(): List<Roadmap> = roadmapsClassified.optional()

}

@Table("ROADMAPS")
data class RoadmapEntity(@Id val id: String?, val mentor: String, val steps: List<Step>)

interface RoadmapCrudRepository : CrudRepository<RoadmapEntity, String> {

    @Query("select * from roadmaps")
    fun findAllRoadmaps(): List<RoadmapEntity>
}

@Service
class RoadmapH2Repository(val roadmapCrudRepository: RoadmapCrudRepository) : RoadmapsRepository {

    override fun findAllRoadmaps(): List<Roadmap> {
        return roadmapCrudRepository.findAllRoadmaps().map {
            Roadmap(it.mentor, it.steps)
        }
    }
}


@Service
class RoadmapsClassified(val roadmapsClassifier: RoadmapsClassifier) {

    fun mandatory(): List<Roadmap> {
        return roadmapsClassifier.mandatory()
    }

    fun optional(): List<Roadmap> {
        return roadmapsClassifier.optional()
    }


}


