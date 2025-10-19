package calculator.strategy;

import calculator.parser.InputParser;

public class CustomDelimiterStrategy implements DelimiterStrategy {
    private final InputParser inputParser;

    public CustomDelimiterStrategy(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    @Override
    public boolean canHandle(String input) {
        return inputParser.hasCustomDelimiter(input);
    }

    @Override
    public String[] splitNumbers(String input) {
        String customDelimiter = inputParser.extractCustomDelimiter(input);
        String numbers = inputParser.extractNumbers(input);
        return numbers.split(customDelimiter);
    }
}