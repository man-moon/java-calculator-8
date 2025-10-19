package calculator.factory;

import calculator.strategy.DelimiterStrategy;
import java.util.List;

public interface DelimiterStrategyFactory {
    List<DelimiterStrategy> createStrategies();
}