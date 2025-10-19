package calculator.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultDelimiterStrategyTest {
    private DefaultDelimiterStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new DefaultDelimiterStrategy();
    }

    @Test
    void 기본_구분자_처리_가능_확인() {
        assertThat(strategy.canHandle("1,2:3")).isTrue();
        assertThat(strategy.canHandle("//;\\n1;2")).isFalse();
    }

    @Test
    void 쉼표_콜론_구분자로_분할() {
        String[] result = strategy.splitNumbers("1,2:3,4");
        assertThat(result).containsExactly("1", "2", "3", "4");
    }
}