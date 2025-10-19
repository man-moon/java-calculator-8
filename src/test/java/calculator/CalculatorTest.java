package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void 빈_문자열_입력시_0_반환() {
        String input = "";

        Calculator calculator = new Calculator();
        int result = calculator.add(input);

        assertThat(result).isEqualTo(0);
    }
}
