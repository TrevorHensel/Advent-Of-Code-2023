package challenges.interfaces;

import challenges.helpers.InputImporter;

import java.util.Arrays;
import java.util.List;

public abstract class AdventChallengeDayFourthInput implements AdventChallengeDay {
    protected static String INPUT_FILE_PATH = "src/input/input-Day4.txt";
    protected static List<String> INPUT = InputImporter.getInputFromFile(INPUT_FILE_PATH);

    protected static int getNumberOfWinningNumbersInASingleGame(String game) {
        String ticket = game.split(":")[1].trim();
        String winningNumbers = ticket.split("\\|")[0].trim();
        String numbersInPlay = ticket.split("\\|")[1].trim();
        String[] winningNumbersArray = winningNumbers.split("\\s+");
        String[] numbersInPlayArray = numbersInPlay.split("\\s+");
        return getNumberOfWinningNumbersInASingleGame(winningNumbersArray, numbersInPlayArray);
    }

    private static int getNumberOfWinningNumbersInASingleGame(String[] winningNumbersArray, String[] numbersInPlayArray) {
        int sum = 0;
        for (String winningNumber : winningNumbersArray) {
            if (Arrays.stream(numbersInPlayArray).anyMatch(numberInPlay -> numberInPlay.equals(winningNumber))) {
               ++sum;
            }
        }
        return sum;
    }
}
