package calculator.factory;

import calculator.parser.InputParser;
import calculator.strategy.CustomDelimiterStrategy;
import calculator.strategy.DefaultDelimiterStrategy;
import calculator.strategy.DelimiterStrategy;
import java.util.List;

public class DelimiterStrategyFactoryImpl implements DelimiterStrategyFactory {
    @Override
    public List<DelimiterStrategy> createStrategies() {
        InputParser inputParser = new InputParser();
        return List.of(
                new CustomDelimiterStrategy(inputParser),
                new DefaultDelimiterStrategy()
        );
    }
}