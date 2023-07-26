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
        return null;
    }

    /**
     * Find the best student (the one with the highest average grade)
     * @param students list of students
     * @return best student name
     */
    public static String findBestStudent(List<StudentData> students) {
        return null;
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

        return null;
    }

}
