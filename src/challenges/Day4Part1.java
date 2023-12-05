package challenges;

import challenges.interfaces.AdventChallengeDayFourthInput;

public class Day4Part1 extends AdventChallengeDayFourthInput {

    private Day4Part1() {
        // empty constructor
    }

    public static void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        int answer = getPointsFromWinningTickets();
        System.out.println("Day 4-1 Solution: " + answer);
    }

    private static int getPointsFromWinningTickets() {
        int sum = 0;
        for (String line : INPUT) {
            int amountOfWinningNumbers = getNumberOfWinningNumbersInASingleGame(line);

            if (amountOfWinningNumbers == 0) {
                continue;
            }

            sum += (int) Math.pow(2, amountOfWinningNumbers - 1);
        }
        return sum;
    }
}
