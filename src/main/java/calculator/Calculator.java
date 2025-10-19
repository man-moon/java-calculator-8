package calculator;

public class Calculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final int CUSTOM_DELIMITER_END_INDEX = 3;
    private static final int NUMBERS_START_INDEX = 5;

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (hasCustomDelimiter(input)) {
            return processCustomDelimiter(input);
        }
        return processDefaultDelimiter(input);
    }

    private int processCustomDelimiter(String input) {
        String customDelimiter = extractCustomDelimiter(input);
        String numbers = extractNumbers(input);
        return sumNumbers(numbers.split(customDelimiter));
    }

    private int processDefaultDelimiter(String input) {
        return sumNumbers(input.split(DEFAULT_DELIMITER));
    }

    private String extractCustomDelimiter(String input) {
        return input.substring(CUSTOM_DELIMITER_START_INDEX, CUSTOM_DELIMITER_END_INDEX);
    }

    private String extractNumbers(String input) {
        return input.substring(NUMBERS_START_INDEX);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}