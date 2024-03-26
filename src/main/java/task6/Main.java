package task6;
import task6.deserial.RawDataStudentDeserializer;
import task6.serial.RawDataSerializer;
import task6.StudentStorage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import task6.Student;
import task6.serial.StudentSerializer;
import task6.utils.FileUtils;
import task6.deserial.StudentDeserializer;

public class Main {



    public static void main(String[] args) {
        StudentStorage storage;


        storage = getStorageForTask6();


        StudentSerializationTester tester = new StudentSerializationTester(storage);
        tester.runTests();

        runCustomTests(storage);
    }

    private static void runCustomTests(StudentStorage storage) {
            try {
                // Scrieți aici testele personalizate
                // De exemplu:
                testSerializationDeserialization(storage);
            } catch (IOException e) {
                System.err.println("An IOException occurred during custom tests: " + e.getMessage());
            }
        }

        private static void testSerializationDeserialization(StudentStorage storage) throws IOException {
            Student student = new Student("John Doe");
            student.addCourseInformation("Math", 9.5);
            student.addCourseInformation("Physics", 8.7);

            String filePath = "./customTest.out";


            writeAndReadStudent(storage, student, filePath);
        }

        private static void writeAndReadStudent(StudentStorage storage, Student student, String filePath) throws IOException {
            try (OutputStream outputStream = FileUtils.openFileForWriting(filePath)) {
                List<Student> studentList = Collections.singletonList(student);
                storage.writeAllStudents(outputStream, studentList);
            }
            try (InputStream inputStream = FileUtils.openFileForReading(filePath)) {
                List<Student> studentsFromFile = storage.readAllStudents(inputStream);

                if (studentsFromFile.contains(student)) {
                    System.out.println("Custom test passed: Serialization and deserialization!");
                } else {
                    System.err.println("Custom test failed: Serialization and deserialization!");
                }
            }
        }


    private static StudentStorage getStorageForTask6() {
        return new StudentStorage(new RawDataSerializer(), new RawDataStudentDeserializer());
    }


}