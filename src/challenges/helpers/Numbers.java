package challenges.helpers;

public enum Numbers {
    ONE(1, 3, "one"),
    TWO(2, 3, "two"),
    THREE(3, 5, "three"),
    FOUR(4, 4, "four"),
    FIVE(5, 4, "five"),
    SIX(6, 3, "six"),
    SEVEN(7, 5, "seven"),
    EIGHT(8, 5, "eight"),
    NINE(9, 4, "nine");

    private final int value;
    private final int length;
    private final String word;

    Numbers(int value, int length, String word) {
        this.value = value;
        this.length = length;
        this.word = word;
    }

    public int getValue() {
        return value;
    }

    public int getLength() {
        return length;
    }

    public String getWord() {
        return word;
    }

    public static Numbers getNumber(int number) {
        return switch (number) {
            case 1 -> ONE;
            case 2 -> TWO;
            case 3 -> THREE;
            case 4 -> FOUR;
            case 5 -> FIVE;
            case 6 -> SIX;
            case 7 -> SEVEN;
            case 8 -> EIGHT;
            case 9 -> NINE;
            default -> null;
        };
    }

    public static Numbers getNumber(String number) {
        return switch (number) {
            case "one" -> ONE;
            case "two" -> TWO;
            case "three" -> THREE;
            case "four" -> FOUR;
            case "five" -> FIVE;
            case "six" -> SIX;
            case "seven" -> SEVEN;
            case "eight" -> EIGHT;
            case "nine" -> NINE;
            default -> null;
        };
    }
}
