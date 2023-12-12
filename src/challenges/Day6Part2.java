package challenges;

import challenges.interfaces.AdventChallengeDaySixthInput;

public class Day6Part2 implements AdventChallengeDaySixthInput {

    private static final long TIME = getValue(0);
    private static final long DISTANCE = getValue(1);

    private Day6Part2() {
        // empty constructor
    }

    private static long getValue(int index) {
        String line = INPUT.get(index);
        String value = line.split(":\\s+")[1];

        return Long.parseLong(value.replaceAll("\\s+", ""));
    }

    public static void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        long answer = AdventChallengeDaySixthInput.calculateNumberOfWaysToBeatRecord(TIME, DISTANCE);

        System.out.println("Day 6 Part 2 solution: " + answer);
    }
}
