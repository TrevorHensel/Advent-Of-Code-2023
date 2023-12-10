package challenges;

import challenges.interfaces.AdventChallengeDayFifthInput;

import java.util.ArrayList;
import java.util.List;

public class Day5Part2 implements AdventChallengeDayFifthInput {

    private Day5Part2() {
        // empty constructor
    }

    public static void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        // long answer = getLowestLocation();

        // This is the answer I got from running the code above, it takes a while to run
        long answer = 24261545;
        System.out.println("Day 5 Part 2 solution: " + answer);
    }

    private static Long getLowestLocation() {
        long lowestLocation = Long.MAX_VALUE;
        int index = 0;
        while(index < SEEDS.size()) {
            long startValue = SEEDS.get(index);
            long range = SEEDS.get(index + 1) - 1;
            for (long i = startValue; i <= startValue + range; ++i) {
                long tempLocation = AdventChallengeDayFifthInput.getSeedLocation(i);
                if (tempLocation < lowestLocation) {
                    lowestLocation = tempLocation;
                }
            }

            // Skip the next one since that is the range value
            index += 2;
        }

        return lowestLocation;
    }
}
