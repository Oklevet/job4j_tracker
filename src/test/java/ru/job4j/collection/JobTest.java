package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByPriority() {
        Comparator<Job> cmpPriority = new JobByPriorityLn();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorDescByPriority() {
        Comparator<Job> cmpDescPriority = new JobDescByPriorityLn();
        int rsl = cmpDescPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByName() {
        Comparator<Job> cmpName = new JobByNameLn();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorDescByName() {
        Comparator<Job> cmpDescName = new JobDescByNameLn();
        int rsl = cmpDescName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorDescByNameAndDescPriority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByNameLn().thenComparing(new JobDescByPriorityLn());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority =
                new JobByNameLn().thenComparing(new JobByPriorityLn());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndDescPriority() {
        Comparator<Job> cmpNamePriority =
                new JobByNameLn().thenComparing(new JobDescByPriorityLn());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void worEqualByNameAndDescPriority() {
        Comparator<Job> cmpNamePriority =
                new JobByNameLn().thenComparing(new JobDescByPriorityLn());
        int rsl = cmpNamePriority.compare(
                new Job("qwe", 0),
                new Job("qwe", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void worEqualByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobByNameLn().thenComparing(new JobByPriorityLn());
        int rsl = cmpNamePriority.compare(
                new Job("qwe", 13),
                new Job("qwe", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void worEqualByNameAndEqualPriority() {
        Comparator<Job> cmpNamePriority = new JobByNameLn().thenComparing(new JobByPriorityLn());
        int rsl = cmpNamePriority.compare(
                new Job("qwe", 1),
                new Job("qwe", 1)
        );
        assertThat(rsl, is(0));
    }
}