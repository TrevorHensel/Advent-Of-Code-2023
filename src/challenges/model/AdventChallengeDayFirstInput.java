package challenges.model;

import challenges.helpers.InputImporter;

import java.util.List;

public interface AdventChallengeDayFirstInput extends AdventChallengeDay {
    String INPUT_FILE_PATH = "src/input/input-Day1.txt";
    List<String> INPUT = InputImporter.getInputFromFile(INPUT_FILE_PATH);
}
