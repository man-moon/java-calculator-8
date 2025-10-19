package calculator.strategy;

public interface DelimiterStrategy {
    boolean canHandle(String input);

    String[] splitNumbers(String input);
}