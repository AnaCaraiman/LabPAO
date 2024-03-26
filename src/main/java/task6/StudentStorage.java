package task6;
import task6.deserial.StudentDeserializer;
import task6.serial.StudentSerializer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class StudentStorage {
    private final StudentSerializer serializer;
    private final StudentDeserializer deserializer;

    public StudentStorage(StudentSerializer serializer, StudentDeserializer deserializer) {
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public List<Student> readAllStudents(InputStream inputStream) {
        List<Student> students = new ArrayList<>();
        try (DataInputStream in = new DataInputStream(inputStream)) {
            while (in.available() > 0) {
                students.add(deserializer.deserializer(in));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void writeAllStudents(OutputStream outputStream, List<Student> students) {
        for (Student student : students) {
            serializer.serialize(outputStream, student);
        }
    }
}