package calculator.strategy;

import static calculator.config.DelimiterConfig.CUSTOM_DELIMITER_PATTERN;

import calculator.parser.InputParser;
import java.util.regex.Matcher;

public class CustomDelimiterStrategy implements DelimiterStrategy {
    private final InputParser inputParser;

    public CustomDelimiterStrategy(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    @Override
    public boolean canHandle(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        return matcher.matches();
    }

    @Override
    public String[] splitNumbers(String input) {
        String customDelimiter = inputParser.extractCustomDelimiter(input);
        String numbers = inputParser.extractNumbers(input);
        if (numbers.isEmpty()) {
            return new String[0];
        }
        return numbers.split("[,:" + customDelimiter + "]");
    }
}