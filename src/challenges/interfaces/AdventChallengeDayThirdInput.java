package challenges.interfaces;

import challenges.helpers.InputImporter;

import java.util.List;

public interface AdventChallengeDayThirdInput {
    String INPUT_FILE_PATH = "src/input/input-Day3.txt";
    List<String> INPUT = InputImporter.getInputFromFile(INPUT_FILE_PATH);
}
