package io.simplify.infra


import io.simplify.core.roadmaps.port.`in`.RoadmapsClassifier
import io.simplify.core.roadmaps.usecase.RoadmapsClassifierByMentor
import io.simplify.infra.adapter.RoadmapH2Repository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RoadmapsConfiguration {
    @Bean
    fun roadmaps(db: RoadmapH2Repository): RoadmapsClassifier {
        return RoadmapsClassifierByMentor(db)
    }
}

@SpringBootApplication
class HexagonalArchitectureApplication


fun main(args: Array<String>) {
    runApplication<HexagonalArchitectureApplication>(*args)
}
