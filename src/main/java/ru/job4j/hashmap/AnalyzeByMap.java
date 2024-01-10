package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0D;
        int totalSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalSubjects++;
            }
        }
        return totalScore / totalSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        double averagePupilScore = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                averagePupilScore += subject.score();
            }
            averagePupilScore /= pupil.subjects().size();
            labels.add(new Label(pupil.name(), averagePupilScore));
            averagePupilScore = 0D;
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> score = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Integer updatedScore =
                        score.containsKey(subject.name()) ? subject.score() + score.get(subject.name()) : subject.score();
                score.put(subject.name(), updatedScore);
            }
        }
        for (String name : score.keySet()) {
            labels.add(new Label(name, (double) score.get(name) / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        double averagePupilScore = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                averagePupilScore += subject.score();
            }
            labels.add(new Label(pupil.name(), averagePupilScore));
            averagePupilScore = 0D;
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> score = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Integer updatedScore =
                        score.containsKey(subject.name()) ? subject.score() + score.get(subject.name()) : subject.score();
                score.put(subject.name(), updatedScore);
            }
        }
        for (String name : score.keySet()) {
            labels.add(new Label(name, (double) score.get(name)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}