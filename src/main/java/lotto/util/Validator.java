package lotto.util;

import lotto.domain.WinningNumbers;

import java.util.List;

public class Validator {
    public static final String message = "[ERROR]";

    private Validator() {
    }

    public static void duplicateNumbers(List<Integer> numbers) {
        long distinct = numbers.stream()
                .mapToInt(Integer::intValue)
                .distinct()
                .count();

        if (distinct != numbers.size()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void duplicateWinningNumbersAndBonusNumber(WinningNumbers winningNumbers, String bonusNumber) {
        if (winningNumbers.getWinningNumbers().contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotNumber(String number) {
        if (!number.matches("\\d+")) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotDivide(String number) {
        if (Integer.parseInt(number) % 1000 != 0) {
            throw new IllegalArgumentException(message + "1000으로 나눠떨어지지 않습니다.");
        }
    }

    public static void checkRange(String number) {
        if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
}
