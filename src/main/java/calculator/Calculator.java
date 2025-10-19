package calculator;

public class Calculator {

    private final String DEFAULT_DELIMITER = "[,:]";

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(DEFAULT_DELIMITER);
        return sumNumbers(numbers);
    }

    public int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}