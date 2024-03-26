package task6.deserial;
import task6.Student;
import java.io.IOException;
import java.io.InputStream;

public interface StudentDeserializer {
    Student deserializer(InputStream inputStream);
}