package challenges.interfaces;

import challenges.helpers.InputImporter;
import challenges.helpers.SchematicValuesHelper;
import challenges.models.SchematicValue;

import java.util.List;

public abstract class AdventChallengeDayThirdInput {
    protected static final String INPUT_FILE_PATH = "src/input/input-Day3.txt";
    protected static final List<String> INPUT = InputImporter.getInputFromFile(INPUT_FILE_PATH);
    protected static final char[][] SCHEMATIC = getSchematic();
    protected static final List<SchematicValue> SCHEMATIC_VALUES = SchematicValuesHelper.buildListOfSchematicValues(SCHEMATIC);

    private static char[][] getSchematic() {
        // Assuming all lines are of same length since it's a grid
        char[][] schematic = new char[INPUT.get(0).length()][INPUT.size()];

        int xIndex = 0;
        for (String line : INPUT) {
            schematic[xIndex] = line.toCharArray();
            ++xIndex;
        }

        return schematic;
    }
}
