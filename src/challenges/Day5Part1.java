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

        long answer = getLowestLocation();
        System.out.println("Day 5 Part 1 solution: " + answer);
    }

    private static long getLowestLocation() {
        long lowestLocation = Long.MAX_VALUE;

        for (long seed : SEEDS) {
            long seedLocation = getSeedLocation(seed);
            if (seedLocation < lowestLocation) {
                lowestLocation = seedLocation;
            }
        }

        return lowestLocation;
    }

    private static long getSeedLocation(long seed) {
        long soil = getDestinationFromTableGivenASource(seed, SEED_TO_SOIL_TABLE);
        long fertilizer = getDestinationFromTableGivenASource(soil, SOIL_TO_FERTILIZER_TABLE);
        long water = getDestinationFromTableGivenASource(fertilizer, FERTILIZER_TO_WATER_TABLE);
        long light = getDestinationFromTableGivenASource(water, WATER_TO_LIGHT_TABLE);
        long temperature = getDestinationFromTableGivenASource(light, LIGHT_TO_TEMPERATURE_TABLE);
        long humidity = getDestinationFromTableGivenASource(temperature, TEMPERATURE_TO_HUMIDITY_TABLE);
        long location = getDestinationFromTableGivenASource(humidity, HUMIDITY_TO_LOCATION_TABLE);
        return location;
    }

    private static long getDestinationFromTableGivenASource(long sourceValue, List<List<Long>> table) {
        for (List<Long> destinationToSource : table) {
            long destinationStartVale = destinationToSource.get(0);
            long sourceStartValue = destinationToSource.get(1);
            long range = destinationToSource.get(2) - 1;
            if (sourceValue >= sourceStartValue && sourceValue < sourceStartValue + range) {
                return destinationStartVale + (sourceValue - sourceStartValue);
            }
        }

        // If no match then just return the value
        return sourceValue;
    }
}
