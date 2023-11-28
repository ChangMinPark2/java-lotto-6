package lotto.controller;

import lotto.domain.Discriminator;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.domain.NumberGenerator.*;
import static lotto.view.InputView.inputBonusNumber;

public class LottoController {
    public void gameStart() {
        String inputPrice = InputView.inputPrice();
        Lottos lottos = lottosCheck(inputPrice);
        OutputView.lottoList(lottos);

        String inputWinningNumbers = InputView.inputWinningNumbers();
        WinningNumbers winningNumbers = checkWinningNumbers(inputWinningNumbers);
        System.out.println();
        String bonusNumber = InputView.inputBonusNumber();
        checkBonusNumber(winningNumbers, bonusNumber);
        Discriminator discriminator = new Discriminator();
        discriminator.howManyLotto(lottos, winningNumbers, bonusNumber);
        OutputView.resultPrint(discriminator, inputPrice);
    }

    private Lottos lottosCheck(String inputPrice) {
        try {
            return new Lottos(generateLottos(inputPrice), lottoCount(inputPrice));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return lottosCheck(InputView.inputPrice());
        }
    }

    private WinningNumbers checkWinningNumbers(String inputWinningNumbers) {
        try {
            return new WinningNumbers(generateWinningNumbers(inputWinningNumbers));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkWinningNumbers(InputView.inputWinningNumbers());
        }
    }

    private String checkBonusNumber(WinningNumbers winningNumbers, String inputBonusNumber) {
        try {
            Validator.duplicateWinningNumbersAndBonusNumber(winningNumbers, inputBonusNumber);
            Validator.isNotNumber(inputBonusNumber);
            Validator.checkRange(inputBonusNumber);
            return inputBonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return checkBonusNumber(winningNumbers, InputView.inputBonusNumber());
        }
    }

}
