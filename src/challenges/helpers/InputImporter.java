package challenges.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class InputImporter {
    private static final Logger LOGGER = Logger.getLogger(InputImporter.class.getSimpleName());

    public static List<String> getInputFromFile(String inputFilePath) {
        try{
            return Files.readAllLines(Paths.get(inputFilePath));
        } catch (IOException e) {
            LOGGER.severe("Failed to read input file");
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
