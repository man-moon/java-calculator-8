package calculator;

public class Calculator {

    private static final String DEFAULT_DELIMITER = "[,:]";

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (input.startsWith("//")) {
            String customDelimiter = input.substring(2, 3);
            String afterDelimiter = input.substring(5);
            String[] numbers = afterDelimiter.split(customDelimiter);
            return sumNumbers(numbers);
        }

        String[] numbers = input.split(DEFAULT_DELIMITER);
        return sumNumbers(numbers);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}