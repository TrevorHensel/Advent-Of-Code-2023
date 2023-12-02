package challenges;

import challenges.interfaces.AdventChallengeDaySecondInput;


public class Day2Part2 implements AdventChallengeDaySecondInput {

    private Day2Part2() {
        // empty constructor
    }

    public static void getSolution() {
        if (INPUT.isEmpty()) {
            System.out.println("Input file is empty");
            return;
        }

        int answer = getSumOfPowersOfMinimumSetsPerGame();
        System.out.println("Day 2-2 Solution: " + answer);
    }

    private static int getSumOfPowersOfMinimumSetsPerGame() {
        int sum = 0;
        for (String line : INPUT) {
            String gameResults = line.split(":")[1];
            sum += getSumOfPowerOfMinimumSet(gameResults);
        }
        return sum;
    }

    private static int getSumOfPowerOfMinimumSet(String gameResults) {
        int minRedCubes = 0;
        int minGreenCubes = 0;
        int minBlueCubes = 0;

        gameResults = gameResults.replaceAll("\\s", "");
        gameResults = gameResults.replaceAll(";", ",");
        String[] cubes = gameResults.split(",");
        for (String cube : cubes) {
            if (cube.contains("red")) {
                int redCubes = Integer.parseInt(cube.replace("red", ""));
                if (redCubes > minRedCubes) {
                    minRedCubes = redCubes;
                }
            } else if (cube.contains("green")) {
                int greenCubes = Integer.parseInt(cube.replace("green", ""));
                if (greenCubes > minGreenCubes) {
                    minGreenCubes = greenCubes;
                }
            } else if (cube.contains("blue")) {
                int blueCubes = Integer.parseInt(cube.replace("blue", ""));
                if (blueCubes > minBlueCubes) {
                    minBlueCubes = blueCubes;
                }
            }
        }

        return minRedCubes * minGreenCubes * minBlueCubes;
    }
}
