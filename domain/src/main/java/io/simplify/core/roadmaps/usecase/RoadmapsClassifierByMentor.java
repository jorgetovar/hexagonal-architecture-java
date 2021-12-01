package io.simplify.core.roadmaps.usecase;

import io.simplify.core.roadmaps.domain.Roadmap;
import io.simplify.core.roadmaps.port.in.RoadmapsClassifier;
import io.simplify.core.roadmaps.port.out.RoadmapsRepository;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class RoadmapsClassifierByMentor implements RoadmapsClassifier {

    private final RoadmapsRepository roadmapsRepository;

    private final List<String> moreThan20YearsOfExperience =
            List.of("Rich Hickey", "Uncle Bob", "Sandro Mancuso", "Venkat Subramaniam", "Victor Rentea");

    private final List<String> atLeast10YearsOfExperience = List.of("Jorge Tovar");

    public RoadmapsClassifierByMentor(RoadmapsRepository roadmapsRepository) {
        this.roadmapsRepository = roadmapsRepository;
    }

    @Override
    public List<Roadmap> mandatory() {
        return classify(e -> moreThan20YearsOfExperience.contains(e.getMentor()));
    }

    @Override
    public List<Roadmap> optional() {
        return classify(e -> atLeast10YearsOfExperience.contains(e.getMentor()));
    }

    private List<Roadmap> classify(Predicate<Roadmap> roadmapPredicate) {
        return roadmapsRepository.findAllRoadmaps()
                .stream()
                .filter(roadmapPredicate)
                .collect(toList());
    }

}
