package io.simplify.core.roadmaps.port.out;

import io.simplify.core.roadmaps.domain.Roadmap;

import java.util.List;

public interface RoadmapsRepository {

    List<Roadmap> findAllRoadmaps();
}
