package challenges;

import challenges.interfaces.AdventChallengeDayThirdInput;
import challenges.models.SchematicValue;

import java.util.List;

public class Day3Part1 extends AdventChallengeDayThirdInput {

    private Day3Part1() {
        // empty constructor
    }

    public static void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        int answer = getSumOfAllPartNumbers();
        System.out.println("Day 3-1 Solution: " + answer);
    }

    private static int getSumOfAllPartNumbers() {
        int sum = 0;
        for (SchematicValue schematicValue : SCHEMATIC_VALUES) {
            if (isPartNumberValid(schematicValue)) {
                sum += Integer.parseInt(schematicValue.getValue());
            }
        }
        return sum;
    }

    private static boolean isPartNumberValid(SchematicValue schematicValue) {
        int x = schematicValue.getX();
        int y = schematicValue.getY();

        /*
         * Do a loop around each number in the schematic and determine if there are any non-'.' values around it
         */
        int xIndex = x - 1;
        int yIndex = y - 1;
        while (yIndex <= y + 1) {
            while (xIndex <= x + schematicValue.getLength()) {
                if (xIndex >= 0 && xIndex < SCHEMATIC.length &&
                    !(yIndex == y && xIndex >= x && xIndex < x + schematicValue.getLength()) &&
                    yIndex >= 0 && yIndex < SCHEMATIC[xIndex].length &&
                    SCHEMATIC[yIndex][xIndex] != '.'
                ) {
                    return true;
                }
                ++xIndex;
            }
            xIndex = x - 1;
            ++yIndex;
        }

        return false;
    }
}
