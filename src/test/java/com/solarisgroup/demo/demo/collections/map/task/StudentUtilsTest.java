package com.solarisgroup.demo.demo.collections.map.task;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentUtilsTest {

    @Test
    void shouldFindAverageGradeByStudent() {
        var students = List.of(
                new StudentData("Ben", Map.of("Math", 100, "English", 90, "History", 80)),
                new StudentData("Alice", Map.of("Math", 80, "English", 100, "History", 60))
        );
        var result = StudentUtils.averageGradeByStudent(students);

        assertEquals(90, result.get("Ben"));
        assertEquals(80, result.get("Alice"));
    }

    @Test
    void shouldFindBestStudent() {
        var students = List.of(
                new StudentData("Ben", Map.of("Math", 100, "English", 90, "History", 80)),
                new StudentData("Alice", Map.of("Math", 80, "English", 100, "History", 60))
        );

        var result = StudentUtils.findBestStudent(students);

        assertEquals("Ben", result);
    }

    @Test
    void shouldFindSubjectWithBestAverageGrade() {
        var students = List.of(
                new StudentData("Ben", Map.of("Math", 100, "English", 90, "History", 80)),
                new StudentData("Alice", Map.of("Math", 80, "English", 100, "History", 60))
        );

        var result = StudentUtils.findSubjectWithBestAverageGrade(students);

        assertEquals("English", result);
    }

}
