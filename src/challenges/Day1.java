package challenges;

import challenges.model.AdventChallengeDayFirstInput;

import java.util.List;

public class Day1 implements AdventChallengeDayFirstInput {

    private Day1() {
        // Empty constructor
    }

    public static void getSolution()
    {
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
        // TODO don't really need this booleans
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
