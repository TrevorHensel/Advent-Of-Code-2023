package challenges.interfaces;

import challenges.helpers.InputImporter;

import java.util.List;

public interface AdventChallengeDaySecondInput extends AdventChallengeDay {
    String INPUT_FILE_PATH = "src/input/input-Day2.txt";
    List<String> INPUT = InputImporter.getInputFromFile(INPUT_FILE_PATH);
}
