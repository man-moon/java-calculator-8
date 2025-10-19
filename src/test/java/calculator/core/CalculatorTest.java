package calculator.core;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 빈_문자열_입력시_0_반환() {
        String input = "";

        int result = calculator.add(input);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 단일_숫자_입력시_해당_숫자_반환() {
        String input = "5";

        int result = calculator.add(input);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 쉼표_구분자_숫자_합_반환() {
        String input = "1,2,3,4";

        int result = calculator.add(input);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void 콜론_구분자_숫자_합_반환() {
        String input = "1:2:3:4";

        int result = calculator.add(input);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void 기본_구분자_숫자_합_반환() {
        String input = "1:2,3:4";

        int result = calculator.add(input);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void 커스텀_구분자_숫자_합_반환() {
        String input = "//@\\n1@2@3@4";

        int result = calculator.add(input);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void 기본_커스텀_구분자_혼합_합_반환() {
        String input = "//#\\n10#20,30:40";

        int result = calculator.add(input);

        assertThat(result).isEqualTo(100);
    }

    @Test
    void 음수가_포함된_경우_예외_발생() {
        String input = "1,2,-3,4";

        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_값이_포함된_경우_예외_발생() {
        String input = "1,2,C,4";

        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
