package challenges.models;

public class SchematicValue {
    private final int x;
    private final int y;
    private final String value;
    private final int length;

    public SchematicValue(int x, int y, String value) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.length = value.length();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getValue() {
        return value;
    }

    public int getLength() {
        return length;
    }
}
