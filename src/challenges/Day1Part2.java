package challenges;

import challenges.helpers.Numbers;
import challenges.model.AdventChallengeDayFirstInput;

/*
Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters: one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".

Equipped with this new information, you now need to find the real first and last digit on each line. For example:

two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen
In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.

What is the sum of all of the calibration values?
 */

public class Day1Part2 implements AdventChallengeDayFirstInput {

    private Day1Part2() {
        // empty constructor
    }

    public static void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        int answer = calculateTotalOfCalibrationValues();
        System.out.println("Day 1-2 Solution: " + answer);
    }

    private static int calculateTotalOfCalibrationValues() {
        int sum = 0;
        for (String line : INPUT) {
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
