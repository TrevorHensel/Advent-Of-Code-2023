package challenges;

import challenges.interfaces.AdventChallengeDayFifthInput;

import java.util.List;

public class Day5Part1 implements AdventChallengeDayFifthInput {

    private Day5Part1() {
        // empty constructor
    }

    public static void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        long answer = AdventChallengeDayFifthInput.getLowestLocation(SEEDS);
        System.out.println("Day 5 Part 1 solution: " + answer);
    }


}
