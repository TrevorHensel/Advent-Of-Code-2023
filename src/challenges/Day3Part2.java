package challenges;

import challenges.interfaces.AdventChallengeDayThirdInput;
import challenges.models.SchematicValue;

import java.util.ArrayList;
import java.util.List;

public class Day3Part2 extends AdventChallengeDayThirdInput {

    private Day3Part2() {
        // empty constructor
    }

    public static void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        int answer = getGearRatios();
        System.out.println("Day 3-2 Solution: " + answer);
    }

    private static int getGearRatios() {
        int sum = 0;

        for (int y = 0; y < SCHEMATIC.length; ++y) {
            for (int x = 0; x < SCHEMATIC[y].length; ++x) {
                if (SCHEMATIC[y][x] == '*') {
                    List<SchematicValue> schematicValues = getSchematicValuesAdjacentToPoint(x, y);
                    if (schematicValues.size() == 2) {
                        sum += Integer.parseInt(schematicValues.get(0).getValue()) * Integer.parseInt(schematicValues.get(1).getValue());
                    }
                }
            }
        }

        return sum;
    }

    private static List<SchematicValue> getSchematicValuesAdjacentToPoint(int x, int y) {
        List<SchematicValue> schematicValues = new ArrayList<>();

        for (int yIndex = y - 1; yIndex <= y + 1; ++yIndex) {
            for (int xIndex = x - 1; xIndex <= x + 1; ++xIndex) {
                if (xIndex >= 0 && xIndex < SCHEMATIC.length &&
                    yIndex >= 0 && yIndex < SCHEMATIC[xIndex].length &&
                    !(xIndex == x && yIndex == y)
                ) {
                    for (SchematicValue schematicValue : SCHEMATIC_VALUES) {
                        if (xIndex >= schematicValue.getX() && xIndex < schematicValue.getX() + schematicValue.getLength() && schematicValue.getY() == yIndex && !schematicValues.contains(schematicValue)) {
                            schematicValues.add(schematicValue);
                        }
                    }
                }
            }
        }
        for (SchematicValue schematicValue : SCHEMATIC_VALUES) {
        }

        return schematicValues;
    }
}
