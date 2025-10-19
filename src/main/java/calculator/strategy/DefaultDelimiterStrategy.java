package calculator.strategy;

import static calculator.config.DelimiterConfig.*;

public class DefaultDelimiterStrategy implements DelimiterStrategy {
    @Override
    public boolean canHandle(String input) {
        return !input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    @Override
    public String[] splitNumbers(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }
}