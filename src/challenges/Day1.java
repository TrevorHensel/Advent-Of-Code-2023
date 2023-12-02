package challenges;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static challenges.helpers.InputImporter.getInputFromFile;

public class Day1 {

    private Day1() {
        // Empty constructor
    }

    private static final String INPUT_FILE_PATH = "src/input/input-Day1.txt";

    public static void getSolution()
    {
        int sum = 0;
        List<String> input = getInputFromFile(INPUT_FILE_PATH);

        if (input.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        for (String line : input) {
            sum += getCalibrationValue(line);
        }

        System.out.println("Solution: " + sum);
    }

    private static int getCalibrationValue(String line) {
        boolean foundFirstDigit = false;
        int calibrationValue = 0;
        int tempLastNumber = 0;

        for (int i = 0; i < line.length(); ++i) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                if (foundFirstDigit) {
                    tempLastNumber = Character.getNumericValue(c);
                }
                else {
                    foundFirstDigit = true;
                    calibrationValue += Character.getNumericValue(c);
                }
            }
        }

        if (tempLastNumber == 0) {
            tempLastNumber = calibrationValue;
        }

        calibrationValue *= 10;
        calibrationValue += tempLastNumber;

        return calibrationValue;
    }
}
