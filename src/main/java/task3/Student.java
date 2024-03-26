package task3;

import java.util.HashMap;
import java.util.Map;

public class Student implements Cloneable {
    private String fullName;
    private Map<String, Double> courseInformation;

    public Student(String fullName, Map<String, Double> courseInformation) {
        this.fullName = fullName;
        this.courseInformation = courseInformation;
    }

    @Override
    public Object clone() {
        try {
            Student cloned = (Student) super.clone();
            cloned.courseInformation = new HashMap<>(this.courseInformation);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Student{fullName='").append(fullName).append("', courseInformation=");
        stringBuilder.append(courseInformation).append('}');
        return stringBuilder.toString();
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Map<String, Double> getCourseInformation() {
        return courseInformation;
    }

    public void setCourseInformation(Map<String, Double> courseInformation) {
        this.courseInformation = courseInformation;
    }
    public void addCourseGrade(String courseName, Double grade) {
        courseInformation.put(courseName, grade);
    }
}

