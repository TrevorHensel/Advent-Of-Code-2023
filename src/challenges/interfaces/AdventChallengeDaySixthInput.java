package challenges.interfaces;

import challenges.helpers.InputImporter;

import java.util.Arrays;
import java.util.List;

public interface AdventChallengeDaySixthInput extends AdventChallengeDay {
    String INPUT_FILE_PATH = "src/input/input-Day6.txt";
    List<String> INPUT = InputImporter.getInputFromFile(INPUT_FILE_PATH);

    static long calculateNumberOfWaysToBeatRecord(long time, long distance) {
        int numberOfWaysToBeatRecord = 0;

        for (long i = 1; i < time; ++i) {
            if (i * (time - i) > distance) {
                ++numberOfWaysToBeatRecord;
            }
        }

        return numberOfWaysToBeatRecord;
    }
}
