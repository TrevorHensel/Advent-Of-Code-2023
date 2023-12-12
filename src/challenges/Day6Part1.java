package challenges;

import challenges.interfaces.AdventChallengeDaySixthInput;

import java.util.Arrays;
import java.util.List;

public class Day6Part1 implements AdventChallengeDaySixthInput {

    private static final List<Integer> TIME_TABLE = getTable(0);
    private static final List<Integer> DISTANCE_TABLE = getTable(1);

    private Day6Part1() {
        // empty constructor
    }

    private static List<Integer> getTable(int index) {
        String table = INPUT.get(index);
        table = table.split(":\\s+")[1];

        return Arrays.stream(table.split("\\s+")).map(s -> Integer.valueOf(Integer.parseInt(s))).toList();
    }

    public static void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        long answer = calculateProductOfNumberOfWayToBeatRecord();
        System.out.println("Day 6 Part 1 solution: " + answer);
    }

    private static long calculateProductOfNumberOfWayToBeatRecord() {
        long productOfNumberOfWayToBeatRecord = 0;
        for (int i = 0; i < TIME_TABLE.size(); ++i) {
            long temp = AdventChallengeDaySixthInput.calculateNumberOfWaysToBeatRecord(TIME_TABLE.get(i), DISTANCE_TABLE.get(i));
            if (productOfNumberOfWayToBeatRecord == 0) {
                productOfNumberOfWayToBeatRecord = temp;
            } else {
                productOfNumberOfWayToBeatRecord *= temp;
            }
        }

        return productOfNumberOfWayToBeatRecord;
    }
}
