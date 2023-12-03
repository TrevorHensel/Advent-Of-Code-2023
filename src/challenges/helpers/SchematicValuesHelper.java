package challenges.helpers;

import challenges.models.SchematicValue;

import java.util.ArrayList;
import java.util.List;

public class SchematicValuesHelper {

    public static List<SchematicValue> buildListOfSchematicValues(char[][] schematic) {
        List<SchematicValue> schematicValues = new ArrayList<>();

        int x;
        for (int y = 0; y < schematic[0].length; ++y) {
            for (x = 0; x < schematic.length; ++x) {
                if (Character.isDigit(schematic[y][x])) {
                    int tempX = x;
                    StringBuilder tempStringBuilder = new StringBuilder();
                    tempStringBuilder.append(schematic[y][x]);
                    ++x;
                    while (x < schematic.length && Character.isDigit(schematic[y][x])) {
                        tempStringBuilder.append(schematic[y][x]);
                        ++x;
                    }

                    /*
                     * A number is only ever on one line. This is why we never change y, but increment x.
                     */
                    schematicValues.add(new SchematicValue(tempX, y, tempStringBuilder.toString()));

                }
            }
        }

        return schematicValues;
    }
}
