package com.solarisgroup.demo.demo.collections.map.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentUtils {

    /**
     * Find the average grade for each student
     * @param students list of students
     * @return map of student name and average grade
     */
    public static Map<String, Integer> averageGradeByStudent(List<StudentData> students) {
        Map<String, Integer> result = new HashMap<>();
        for (StudentData student : students) {
            int sum = 0;
            for (Integer grade : student.grades().values()) {
                sum += grade;
            }
            result.put(student.name(), sum / student.grades().size());
        }
        return result;
    }

    /**
     * Find the best student (the one with the highest average grade)
     * @param students list of students
     * @return best student name
     */
    public static String findBestStudent(List<StudentData> students) {
        var averageGradeByStudent = averageGradeByStudent(students);
        int maxGrade = 0;
        String bestStudent = null;
        for (Map.Entry<String, Integer> entry : averageGradeByStudent.entrySet()) {
            if (entry.getValue() > maxGrade) {
                maxGrade = entry.getValue();
                bestStudent = entry.getKey();
            }
        }
        return bestStudent;
    }

    /**
     * Find the subject with the best average grade
     * @param students list of students
     * @return subject name
     */
    public static String findSubjectWithBestAverageGrade(List<StudentData> students) {
        //TBD
        //suggested algorithm:
        //1. group grades by subject (Map<String, List<Integer>>)
        //2. find the average grade for each subject (Map<String, Integer>)
        //3. find the subject with the best average grade

        Map<String, List<Integer>> subjectGrades = new HashMap<>();

        for (var student : students) {
            for (Map.Entry<String, Integer> entry : student.grades().entrySet()) {
                String subject = entry.getKey();
                Integer grade = entry.getValue();

                if (subjectGrades.containsKey(subject)) {
                    subjectGrades.get(subject).add(grade);
                } else {
                    var grades = new ArrayList<Integer>();
                    grades.add(grade);
                    subjectGrades.put(subject, grades);
                }
            }
        }

        Map<String, Integer> subjectAverageGrades = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : subjectGrades.entrySet()) {
            String subject = entry.getKey();
            List<Integer> grades = entry.getValue();

            int sum = 0;
            for (Integer grade : grades) {
                sum += grade;
            }

            int average = sum / grades.size();

            subjectAverageGrades.put(subject, average);
        }

        String bestSubject = null;
        int bestAverage = 0;

        for (Map.Entry<String, Integer> entry : subjectAverageGrades.entrySet()) {
            String subject = entry.getKey();
            Integer average = entry.getValue();

            if (average > bestAverage) {
                bestSubject = subject;
                bestAverage = average;
            }
        }


        return bestSubject;
    }

}
