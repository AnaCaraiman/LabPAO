package task6.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public final class FileUtils {

    public static OutputStream openFileForWriting(String path) throws IOException {
        return new FileOutputStream(path, true); // true pentru a permite append
    }

    public static InputStream openFileForReading(String path) throws FileNotFoundException {
        return new FileInputStream(path);
    }
}
