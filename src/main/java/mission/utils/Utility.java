package mission.utils;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
        int size = list.size();
        List<List<T>> result = new ArrayList<>();

        for (int i = 0; i < size; i += chunkSize) {
            result.add(list.subList(i, Math.min(size, i + chunkSize)));
        }

        return result;
    }

    public static List<Integer> stringToIntegers(String line) {
        return line.chars().map(c -> c - '0').boxed().toList();
    }

    public static int countNonWhitespaceChars(String line) {
        if (line == null) return 0;
        return (int) line.chars()
                .filter(ch -> !Character.isWhitespace(ch))
                .count();
    }

    public static String substringUntilNthChar(String str, char target, int n) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
                if (count == n) {
                    return str.substring(0, i);
                }
            }
        }

        return str;
    }
}
