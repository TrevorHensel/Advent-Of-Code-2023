package challenges.interfaces;

import challenges.helpers.InputImporter;

import java.util.List;

public interface AdventChallengeDayFourthInput extends AdventChallengeDay {
    String INPUT_FILE_PATH = "src/input/input-Day4.txt";
    List<String> INPUT = InputImporter.getInputFromFile(INPUT_FILE_PATH);
}
