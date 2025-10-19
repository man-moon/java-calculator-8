package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void 빈_문자열_입력시_0_반환() {
        String input = "";

        Calculator calculator = new Calculator();
        int result = calculator.add(input);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 단일_숫자_입력시_해당_숫자_반환() {
        String input = "5";

        Calculator calculator = new Calculator();
        int result = calculator.add(input);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 쉼표_구분자_숫자_합_반환() {
        String input = "1,2,3,4";

        Calculator calculator = new Calculator();
        int result = calculator.add(input);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void 콜론_구분자_숫자_합_반환() {
        String input = "1:2:3:4";

        Calculator calculator = new Calculator();
        int result = calculator.add(input);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void 기본_구분자_숫자_합_반환() {
        String input = "1:2,3:4";

        Calculator calculator = new Calculator();
        int result = calculator.add(input);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void 커스텀_구분자_숫자_합_반환() {
        String input = "//@\\n1@2@3@4";

        Calculator calculator = new Calculator();
        int result = calculator.add(input);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void 음수가_포함된_경우_예외_발생() {
        String input = "1,2,-3,4";

        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
