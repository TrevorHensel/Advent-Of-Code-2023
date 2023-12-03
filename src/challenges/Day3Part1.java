package challenges;

import challenges.interfaces.AdventChallengeDayThirdInput;
import challenges.models.SchematicValue;

import java.util.ArrayList;
import java.util.List;

public class Day3Part1 implements AdventChallengeDayThirdInput {

    private Day3Part1() {
        // empty constructor
    }

    public static void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        char[][] schematic = getSchematic();
        List<SchematicValue> schematicValues = buildListOfSchematicValues(schematic);
        int answer = getSumOfAllPartNumbers(schematic, schematicValues);
        System.out.println("Day 3-1 Solution: " + answer);
    }

    private static char[][] getSchematic() {
        // Assuming all lines are of same length since it's a grid
        char[][] schematic = new char[INPUT.get(0).length()][INPUT.size()];

        int xIndex = 0;
        for (String line : INPUT) {
            schematic[xIndex] = line.toCharArray();
            ++xIndex;
        }

        return schematic;
    }

    private static List<SchematicValue> buildListOfSchematicValues(char[][] schematic) {
        List<SchematicValue> schematicValues = new ArrayList<>();

        int x;
        for (int y = 0; y < schematic[0].length; ++y) {
            for (x = 0; x < schematic.length; ++x) {
                if (Character.isDigit(schematic[y][x])) {
                    int tempX = x;
                    StringBuilder tempStringBuilder = new StringBuilder();
                    tempStringBuilder.append(schematic[y][x]);
                    ++x;
                    while (x < schematic.length && Character.isDigit(schematic[y][x])) {
                        tempStringBuilder.append(schematic[y][x]);
                        ++x;
                    }

                    /*
                     * A number is only ever on one line. This is why we never change y, but increment x.
                     */
                    schematicValues.add(new SchematicValue(tempX, y, tempStringBuilder.toString()));

                }
            }
        }

        return schematicValues;
    }

    private static int getSumOfAllPartNumbers(char[][] schematic, List<SchematicValue> schematicValues) {
        int sum = 0;
        for (SchematicValue schematicValue : schematicValues) {
            if (isPartNumberValid(schematic, schematicValue)) {
                sum += Integer.parseInt(schematicValue.getValue());
            }
        }
        return sum;
    }

    private static boolean isPartNumberValid(char[][] schematic, SchematicValue schematicValue) {
        int x = schematicValue.getX();
        int y = schematicValue.getY();

        /*
         * Do a loop around each number in the schematic and determine if there are any non-'.' values around it
         */
        int xIndex = x - 1;
        int yIndex = y - 1;
        while (yIndex <= y + 1) {
            while (xIndex <= x + schematicValue.getLength()) {
                if (xIndex >= 0 && xIndex < schematic.length &&
                    !(yIndex == y && xIndex >= x && xIndex < x + schematicValue.getLength()) &&
                    yIndex >= 0 && yIndex < schematic[xIndex].length &&
                    schematic[yIndex][xIndex] != '.'
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
