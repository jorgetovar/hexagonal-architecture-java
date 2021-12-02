package io.simplify.infra.adapter

import io.simplify.core.roadmaps.domain.Roadmap
import io.simplify.core.roadmaps.port.`in`.RoadmapsClassifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class RoadmapsHttpAdapter(val roadmapsClassifier: RoadmapsClassifier) {

    @GetMapping("/mandatory")
    fun mandatory(): List<Roadmap> = roadmapsClassifier.mandatory()

    @GetMapping("/optional")
    fun optional(): List<Roadmap> = roadmapsClassifier.optional()

}







