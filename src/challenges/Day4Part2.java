package challenges;

import challenges.interfaces.AdventChallengeDayFourthInput;

import java.util.HashMap;
import java.util.Map;

public class Day4Part2 extends AdventChallengeDayFourthInput {

    private Day4Part2() {
        // empty constructor
    }

    public static void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        int answer = getAmountOfWinningTickets();
        System.out.println("Day 4-2 Solution: " + answer);
    }

    private static int getAmountOfWinningTickets() {
        int gameId = 1;
        Map<Integer, Integer> gameIdToNumberOfCopies = getGameIdToNumberOfCopiesMap();

        for (String line : INPUT) {
            int amountOfWinningNumbers = getNumberOfWinningNumbersInASingleGame(line);

            if (amountOfWinningNumbers > 0) {
                int numberOfCopies = gameIdToNumberOfCopies.get(gameId) - 1;
                for (int i = 0; i < numberOfCopies + 1; ++i) {
                    for (int u = 0; u < amountOfWinningNumbers; ++u) {
                        if (gameId + 1 + u > INPUT.size()) {
                            break;
                        }

                        gameIdToNumberOfCopies.put(gameId + 1 + u, gameIdToNumberOfCopies.get(gameId + 1 + u) + 1);
                    }
                }
            }

            ++gameId;
        }

        return gameIdToNumberOfCopies.values().stream().mapToInt(Integer::intValue).sum();
    }

    private static Map<Integer, Integer> getGameIdToNumberOfCopiesMap() {
        Map<Integer, Integer> gameIdToNumberOfCopies = new HashMap<>();

        for (int i = 0; i < INPUT.size(); ++i) {
            gameIdToNumberOfCopies.put(i + 1, 1);
        }

        return gameIdToNumberOfCopies;
    }
}
