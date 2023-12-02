package challenges.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class InputImporter {
    public static List<String> getInputFromFile(String inputFilePath) {
        try{
            return Files.readAllLines(Paths.get(inputFilePath));
        } catch (IOException e) {
            // TODO Logging
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
