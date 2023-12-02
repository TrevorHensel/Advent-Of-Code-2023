package challenges;

import challenges.interfaces.AdventChallengeDaySecondInput;

public class Day2Part1 implements AdventChallengeDaySecondInput {

    private static final int MAX_RED_CUBES = 12;
    private static final int MAX_GREEN_CUBES = 13;
    private static final int MAX_BLUE_CUBES = 14;

    private Day2Part1() {
        // empty constructor
    }

    public static void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        int answer = determineWhichGamesArePossibleGivenTheRules();
        System.out.println("Day 2-1 Solution: " + answer);
    }

    private static int determineWhichGamesArePossibleGivenTheRules() {
        int sum = 0;
        for (String line : INPUT) {
            String[] gameString = line.split(":");
            String gameId = gameString[0];
            String gameResults = gameString[1];

            if (isGamePossible(gameResults)) {
                sum += getGameId(gameId);
            }
        }
        return sum;
    }

    private static boolean isGamePossible(String gameResults) {
        gameResults = gameResults.replaceAll("\\s", "");
        String[] hands = gameResults.split(";");
        for (String hand : hands) {
            if(!isHandPossible(hand)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isHandPossible(String hand)
    {
        String[] cubes = hand.split(",");
        for (String cube : cubes) {
            if (cube.contains("red")) {
                int redCubes = Integer.parseInt(cube.replace("red", ""));
                if (redCubes > MAX_RED_CUBES) {
                    return false;
                }
            } else if (cube.contains("green")) {
                int greenCubes = Integer.parseInt(cube.replace("green", ""));
                if (greenCubes > MAX_GREEN_CUBES) {
                    return false;
                }
            } else if (cube.contains("blue")) {
                int blueCubes = Integer.parseInt(cube.replace("blue", ""));
                if (blueCubes > MAX_BLUE_CUBES) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int getGameId(String gameId) {
        return Integer.parseInt(gameId.replace("Game ", ""));
    }
}
