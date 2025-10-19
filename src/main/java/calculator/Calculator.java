package calculator;

public class Calculator {

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (input.contains(",") || input.contains(":")) {
            String[] numbers = input.split("[,:]");
            int sum = 0;
            for (String num : numbers) {
                sum += Integer.parseInt(num);
            }
            return sum;
        }
        return Integer.parseInt(input);
    }
}