package io.simplify.infra.adapter

import io.simplify.core.roadmaps.domain.Roadmap
import io.simplify.core.roadmaps.domain.Step
import io.simplify.core.roadmaps.port.`in`.RoadmapsClassifier
import io.simplify.core.roadmaps.port.out.RoadmapsRepository
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class RoadmapsHttpAdapter(val roadmapsClassified: RoadmapsClassified, val roadmapService: RoadmapService) {

    @GetMapping("/mandatory")
    fun mandatory(): List<Roadmap> = roadmapsClassified.mandatory()

    @GetMapping("/optional")
    fun optional(): List<Roadmap> = roadmapsClassified.optional()

    @PostMapping("/roadmap")
    fun createResource(@RequestBody roadmap: Roadmap) {
        roadmapService.create(roadmap)
    }

}

@Table("ROADMAPS")
data class RoadmapE(
    @Id val id: String?, val mentor: String,
    @MappedCollection(idColumn = "STEP_ID", keyColumn = "STEP_ID") val steps: List<StepE>
)

@Table("STEPS")
data class StepE(@Id val stepId: String?, val resourceLink: String)


interface RoadmapCrudRepository : CrudRepository<RoadmapE, String> {

    @Query("select * from roadmaps")
    fun findAllRoadmaps(): List<RoadmapE>
}


@Service
class RoadmapH2Repository(val roadmapCrudRepository: RoadmapCrudRepository) : RoadmapsRepository {

    override fun findAllRoadmaps(): List<Roadmap> {
        val roadmaps = roadmapCrudRepository.findAllRoadmaps()
        println(roadmaps)
        return roadmaps.map { e ->
            Roadmap(e.mentor, e.steps.map { Step(it.resourceLink) })
        }
    }
}

@Service
class RoadmapService(val roadmapCrudRepository: RoadmapCrudRepository) {

    fun create(roadmap: Roadmap) {
        val steps = roadmap.steps.map { StepE(null, it.resourceLink) }
        roadmapCrudRepository.save(RoadmapE(null, roadmap.mentor, steps))
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


