package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        Comparator<Job> comparator = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = comparator.compare(
                new Job("A task", 0),
                new Job("A task", 4)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 5)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("Peter's Task", 1),
                new Job("Ivan's Task", 4)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorLessByName() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(
                new Job("Sophie's Task", 1),
                new Job("Zara's Task", 4)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(
                new Job("B task", 5),
                new Job("A task", 4)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(
                new Job("B task", 5),
                new Job("A task", 4)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}