package io.simplify.core.roadmaps.port.in;

import io.simplify.core.roadmaps.domain.Roadmap;

import java.util.List;

public interface RoadmapsClassifier {

    List<Roadmap> mandatory();

    List<Roadmap> optional();

}
