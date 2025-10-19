package calculator.strategy;

import calculator.parser.InputParser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomDelimiterStrategyTest {
    private CustomDelimiterStrategy strategy;

    @BeforeEach
    void setUp() {
        InputParser inputParser = new InputParser();
        strategy = new CustomDelimiterStrategy(inputParser);
    }

    @Test
    void 커스텀_구분자_처리_가능_확인() {
        assertThat(strategy.canHandle("//;\\n1;2")).isTrue();
        assertThat(strategy.canHandle("1,2:3")).isFalse();
    }

    @Test
    void 커스텀_구분자로_분할() {
        String[] result = strategy.splitNumbers("//;\\n1;2;3");
        assertThat(result).containsExactly("1", "2", "3");
    }
}