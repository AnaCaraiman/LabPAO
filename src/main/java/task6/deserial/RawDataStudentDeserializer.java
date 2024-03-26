package task6.deserial;
import task6.Student;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
public class RawDataStudentDeserializer implements StudentDeserializer {
    @Override
    public Student deserializer(InputStream inputStream) {
        try (DataInputStream in = new DataInputStream(inputStream)) {
            String fullName = in.readUTF();
            int numCourses = in.readInt();
            Map<String, Double> courseInformation = new HashMap<>();
            for (int i = 0; i < numCourses; i++) {
                String courseName = in.readUTF();
                double grade = in.readDouble();
                courseInformation.put(courseName, grade);
            }
            Student student = new Student(fullName);
            courseInformation.forEach(student::addCourseInformation);
            return student;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
