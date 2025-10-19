package calculator;

public class Calculator {

    public int add(String input) {
        if(input.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(input);
    }
}