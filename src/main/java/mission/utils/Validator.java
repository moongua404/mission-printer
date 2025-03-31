package mission.utils;

public class Validator {
    public static void composeNumeric(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalStateException("[ERROR] 숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }

    public static void positiveInteger(int value) {
        if (value <= 0) {
            throw new IllegalStateException("[ERROR] 양수가 아닙니다.");
        }
    }
}
