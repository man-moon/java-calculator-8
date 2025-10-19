package calculator.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberParserTest {
    private NumberParser numberParser;

    @BeforeEach
    void setUp() {
        numberParser = new NumberParser();
    }

    @Test
    void 양수_파싱_성공() {
        int result = numberParser.parse("5");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 음수_파싱_성공() {
        int result = numberParser.parse("-5");
        assertThat(result).isEqualTo(-5);
    }

    @Test
    void 숫자가_아닌_문자_예외_발생() {
        assertThatThrownBy(() -> numberParser.parse("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_포함_숫자_파싱_성공() {
        int result = numberParser.parse("  5  ");
        assertThat(result).isEqualTo(5);
    }
}