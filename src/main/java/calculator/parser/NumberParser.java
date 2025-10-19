package calculator.parser;

public class NumberParser {
    public int parse(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}