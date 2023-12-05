package challenges;

import challenges.interfaces.AdventChallengeDayFourthInput;

import java.util.Arrays;

public class Day4Part1 implements AdventChallengeDayFourthInput {

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
            String ticket = line.split(":")[1].trim();
            String winningNumbers = ticket.split("\\|")[0].trim();
            String numbersInPlay = ticket.split("\\|")[1].trim();
            String[] winningNumbersArray = winningNumbers.split("\\s+");
            String[] numbersInPlayArray = numbersInPlay.split("\\s+");
            sum += getPointsFromSingleGame(winningNumbersArray, numbersInPlayArray);
        }
        return sum;
    }

    private static int getPointsFromSingleGame(String[] winningNumbersArray, String[] numbersInPlayArray) {
        int sum = 0;
        for (String winningNumber : winningNumbersArray) {
            if (Arrays.stream(numbersInPlayArray).anyMatch(numberInPlay -> numberInPlay.equals(winningNumber))) {
                if (sum == 0) {
                    sum = 1;
                }
                else {
                    sum *= 2;
                }
            }
        }
        return sum;
    }
}
