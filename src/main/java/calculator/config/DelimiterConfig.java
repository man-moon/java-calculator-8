package calculator.config;

import java.util.regex.Pattern;

public final class DelimiterConfig {
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String DEFAULT_DELIMITERS = "[,:]";
    public static final int CUSTOM_DELIMITER_START_INDEX = 2;
    public static final int CUSTOM_DELIMITER_END_INDEX = 3;
    public static final int NUMBERS_START_INDEX = 5;
    public static final Pattern CUSTOM_DELIMITER_PATTERN =
            Pattern.compile("^//(.)\\\\n(?:\\d+(?:(?:\\1|[,:])\\d+)*)?$");
    public static final Pattern DEFAULT_DELIMITER_PATTERN =
            Pattern.compile("^$|^\\d+([,:]\\d+)*$");


    private DelimiterConfig() {
    }
}