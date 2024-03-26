package task3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> courseGrades = new HashMap<>();
        courseGrades.put("Matematica", 9.5);
        courseGrades.put("Istorie", 8.8);
        courseGrades.put("Romana", 7.3);
        Student originalStudent = new Student("Popescu Ion", courseGrades);
        Student clonedStudent = (Student) originalStudent.clone();
        clonedStudent.getCourseInformation().put("Matematica", 9.8);
        clonedStudent.getCourseInformation().put("Istorie", 8.5);
        System.out.println("Original student: " + originalStudent);
        System.out.println("Cloned student: " + clonedStudent);
    }
}
