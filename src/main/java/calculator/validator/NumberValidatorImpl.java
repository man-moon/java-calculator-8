package calculator.validator;

public class NumberValidatorImpl implements NumberValidatorInterface {
    @Override
    public void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }
}