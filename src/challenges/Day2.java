package challenges;

import challenges.model.AdventChallengeDayFirstInput;

import java.util.List;
import java.util.Map;

public class Day2 implements AdventChallengeDayFirstInput {
    private static final Map<String, Integer> lengthToWord = Map.of(
            "one", 3,
            "two", 3,
            "three", 5,
            "four", 4,
            "five", 4,
            "six", 3,
            "seven", 5,
            "eight", 5,
            "nine", 4,
            "ten", 3
    );

    private Day2() {
        // empty constructor
    }

    public void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        int answer = calculateTotalOfCalibrationValues(INPUT);
        System.out.println("Solution: " + answer);
    }

    private static int calculateTotalOfCalibrationValues(List<String> input) {
        int sum = 0;
        for (String line : input) {
            sum += getCalibrationValueForLine(line);
        }
        return sum;
    }

    private static int getCalibrationValueForLine(String line) {
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
