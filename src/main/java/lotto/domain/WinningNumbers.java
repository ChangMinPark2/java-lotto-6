package lotto.domain;

import lotto.util.Validator;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        Validator.duplicateNumbers(winningNumbers);
        Validator.validateSize(winningNumbers);
        Validator.checkRange(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
