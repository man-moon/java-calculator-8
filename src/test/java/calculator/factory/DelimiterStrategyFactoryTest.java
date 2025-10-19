package calculator.factory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.strategy.CustomDelimiterStrategy;
import calculator.strategy.DefaultDelimiterStrategy;
import calculator.strategy.DelimiterStrategy;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DelimiterStrategyFactoryTest {
    private DelimiterStrategyFactory factory;

    @BeforeEach
    void setUp() {
        factory = new DelimiterStrategyFactoryImpl();
    }

    @Test
    void 팩토리_생성_확인() {
        List<DelimiterStrategy> strategies = factory.createStrategies();

        assertThat(strategies.size()).isEqualTo(2);
    }

    @Test
    void 생성된_전략의_구체적인_타입_확인() {
        List<DelimiterStrategy> strategies = factory.createStrategies();

        assertThat(strategies.get(0)).isInstanceOf(CustomDelimiterStrategy.class);
        assertThat(strategies.get(1)).isInstanceOf(DefaultDelimiterStrategy.class);
    }
}
