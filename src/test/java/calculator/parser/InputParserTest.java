package calculator.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {
    private InputParser inputParser;

    @BeforeEach
    void setUp() {
        inputParser = new InputParser();
    }

    @Test
    void 커스텀_구분자_확인() {
        assertThat(inputParser.hasCustomDelimiter("//;\\n1;2")).isTrue();
        assertThat(inputParser.hasCustomDelimiter("1,2:3")).isFalse();
    }

    @Test
    void 커스텀_구분자_추출() {
        String result = inputParser.extractCustomDelimiter("//;\\n1;2;3");
        assertThat(result).isEqualTo(";");
    }

    @Test
    void 숫자_문자열_추출() {
        String result = inputParser.extractNumbers("//;\\n1;2;3");
        assertThat(result).isEqualTo("1;2;3");
    }
}