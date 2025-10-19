package calculator.parser;

import static calculator.config.DelimiterConfig.*;

public class InputParser {

    public boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    public String extractCustomDelimiter(String input) {
        return input.substring(CUSTOM_DELIMITER_START_INDEX, CUSTOM_DELIMITER_END_INDEX);
    }

    public String extractNumbers(String input) {
        return input.substring(NUMBERS_START_INDEX);
    }
}