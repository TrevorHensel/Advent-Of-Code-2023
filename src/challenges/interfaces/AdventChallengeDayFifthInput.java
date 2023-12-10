package challenges.interfaces;

import challenges.helpers.InputImporter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface AdventChallengeDayFifthInput extends AdventChallengeDay {
    String INPUT_FILE_PATH = "src/input/input-Day5.txt";
    List<String> INPUT = InputImporter.getInputFromFile(INPUT_FILE_PATH);
    List<Long> SEEDS = getSeeds();
    List<List<Long>> SEED_TO_SOIL_TABLE = getTable("seed-to-soil map:");
    List<List<Long>> SOIL_TO_FERTILIZER_TABLE = getTable("soil-to-fertilizer map:");
    List<List<Long>> FERTILIZER_TO_WATER_TABLE = getTable("fertilizer-to-water map:");
    List<List<Long>> WATER_TO_LIGHT_TABLE = getTable("water-to-light map:");
    List<List<Long>> LIGHT_TO_TEMPERATURE_TABLE = getTable("light-to-temperature map:");
    List<List<Long>> TEMPERATURE_TO_HUMIDITY_TABLE = getTable("temperature-to-humidity map:");
    List<List<Long>> HUMIDITY_TO_LOCATION_TABLE = getTable("humidity-to-location map:");

    private static List<Long> getSeeds() {
        return Arrays.stream(INPUT.get(0).split("seeds: ")[1].split(" ")).map(Long::parseLong).toList();
    }

    private static List<List<Long>> getTable(String tableTitle) {
        List<List<Long>> seedToSoilTable = new ArrayList<>();

        List<String> inputStartingAtSeedToSoilMap = INPUT.subList(INPUT.indexOf(tableTitle) + 1, INPUT.size());
        int index = 0;

        while (index < inputStartingAtSeedToSoilMap.size() && !inputStartingAtSeedToSoilMap.get(index).isBlank()) {
            String line = inputStartingAtSeedToSoilMap.get(index);

            seedToSoilTable.add(Arrays.stream(line.split(" ")).map(Long::parseLong).toList());
            ++index;
        }

        return seedToSoilTable;
    }
}
