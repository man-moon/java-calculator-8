package calculator.core;

import calculator.factory.DelimiterStrategyFactoryImpl;
import calculator.factory.DelimiterStrategyFactory;
import calculator.parser.NumberParser;
import calculator.strategy.DelimiterStrategy;
import calculator.validator.NumberValidatorImpl;
import calculator.validator.NumberValidatorInterface;
import java.util.List;

public class Calculator {
    private final List<DelimiterStrategy> strategies;
    private final NumberParser numberParser;
    private final NumberValidatorInterface numberValidator;

    public Calculator(DelimiterStrategyFactory strategyFactory, NumberParser numberParser,
                      NumberValidatorInterface numberValidator) {
        this.strategies = strategyFactory.createStrategies();
        this.numberParser = numberParser;
        this.numberValidator = numberValidator;
    }

    public Calculator() {
        this(new DelimiterStrategyFactoryImpl(), new NumberParser(), new NumberValidatorImpl());
    }

    public int add(String input) {
        DelimiterStrategy strategy = findStrategy(input);
        String[] numbers = strategy.splitNumbers(input);
        if(numbers.length == 0) {
            return 0;
        }
        return sumNumbers(numbers);
    }

    private DelimiterStrategy findStrategy(String input) {
        return strategies.stream()
                .filter(strategy -> strategy.canHandle(input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int parsedNumber = numberParser.parse(number);
            numberValidator.validatePositive(parsedNumber);
            sum += parsedNumber;
        }
        return sum;
    }
}