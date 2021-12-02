package io.simplify.core.roadmaps.usecase;

import io.simplify.core.roadmaps.domain.Roadmap;
import io.simplify.core.roadmaps.domain.Step;
import io.simplify.core.roadmaps.port.out.RoadmapsRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RoadmapsClassifierByMentorTest {

    class StubRepository implements RoadmapsRepository {

        @Override
        public List<Roadmap> findAllRoadmaps() {
            return List.of(new Roadmap("Rich Hickey", List.of(new Step("https://www.youtube.com/watch?v=SxdOUGdseq4"))));
        }
    }

    @Test
    void mandatory() {

        RoadmapsClassifierByMentor roadmapsClassifierByMentor = new RoadmapsClassifierByMentor(new StubRepository());
        List<Roadmap> mandatory = roadmapsClassifierByMentor.mandatory();
        assertEquals(mandatory.size(), 1);
        Optional<Roadmap> clojureHacker = mandatory.stream().findFirst();
        clojureHacker.ifPresent(e -> assertEquals(e.getMentor(), "Rich Hickey"));
    }

    @Test
    void optional() {

        RoadmapsClassifierByMentor roadmapsClassifierByMentor = new RoadmapsClassifierByMentor(new StubRepository());
        List<Roadmap> optional = roadmapsClassifierByMentor.optional();
        assertEquals(optional.size(), 0);

    }
}