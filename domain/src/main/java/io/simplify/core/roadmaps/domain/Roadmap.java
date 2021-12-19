package io.simplify.core.roadmaps.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Roadmap {
    private String mentor;
    private Recommendation recommendation;
    private List<Step> steps;

    public Roadmap(String mentor, List<Step> steps) {
        this.mentor = mentor;
        this.steps = steps;
    }

}