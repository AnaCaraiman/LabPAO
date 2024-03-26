package task6.serial;
import task6.Student;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.io.*;
import java.util.List;

public class RawDataSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream outputStream, Student student) {
        try (DataOutputStream out = new DataOutputStream(outputStream)) {
            out.writeUTF(student.getFullName());
            out.writeInt(student.getCourseInformation().size());
            for (var entry : student.getCourseInformation().entrySet()) {
                out.writeUTF(entry.getKey());
                out.writeDouble(entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
