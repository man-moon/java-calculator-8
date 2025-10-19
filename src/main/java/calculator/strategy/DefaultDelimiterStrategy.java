package calculator.strategy;

import static calculator.config.DelimiterConfig.*;

import java.util.regex.Matcher;

public class DefaultDelimiterStrategy implements DelimiterStrategy {
    @Override
    public boolean canHandle(String input) {
        Matcher matcher = DEFAULT_DELIMITER_PATTERN.matcher(input);
        return matcher.matches();
    }

    @Override
    public String[] splitNumbers(String input) {
        if (input.isEmpty()) {
            return new String[0];
        }
        return input.split(DEFAULT_DELIMITERS);
    }
}