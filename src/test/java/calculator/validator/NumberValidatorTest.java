package calculator.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberValidatorTest {
    private NumberValidatorImpl numberValidator;

    @BeforeEach
    void setUp() {
        numberValidator = new NumberValidatorImpl();
    }

    @Test
    void 양수_검증_성공() {
        numberValidator.validatePositive(5);
    }

    @Test
    void 음수_예외_발생() {
        assertThatThrownBy(() -> numberValidator.validatePositive(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}