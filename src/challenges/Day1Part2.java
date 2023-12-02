package challenges;

import challenges.helpers.Numbers;
import challenges.model.AdventChallengeDayFirstInput;

import java.util.List;

public class Day1Part2 implements AdventChallengeDayFirstInput {

    private Day1Part2() {
        // empty constructor
    }

    public static void getSolution() {
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
            Numbers number = getCurrentIndexInLineAsANumber(line, i);
            if (number != null) {
                if (foundFirstDigit) {
                    tempLastNumber = number.getValue();
                }
                else {
                    foundFirstDigit = true;
                    calibrationValue += number.getValue();
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

    private static Numbers getCurrentIndexInLineAsANumber(String line, int index) {
        char c = line.charAt(index);
        if (Character.isDigit(c)) {
            return Numbers.getNumber(Character.getNumericValue(c));
        }

        for(int i = 0; i < Numbers.values().length; ++i) {
            Numbers number = Numbers.values()[i];
            int endIndex = index + number.getLength();
            if (endIndex > line.length()) {
                continue;
            }
            if (line.substring(index, endIndex).equals(number.getWord())) {
                return number;
            }
        }
        return null;
    }
}
