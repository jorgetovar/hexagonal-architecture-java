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
import org.springframework.web.bind.annotation.RestController


@RestController
class RoadmapsHttpAdapter(val roadmapsClassifier: RoadmapsClassifier) {

    @GetMapping("/mandatory")
    fun mandatory(): List<Roadmap> = roadmapsClassifier.mandatory()

    @GetMapping("/optional")
    fun optional(): List<Roadmap> = roadmapsClassifier.optional()

}







