package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.GlobalConstant.*;

public class NumberGenerator {
    public static List<Integer> generateRandomNumbers() {
        List<Integer> list = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT));
        Collections.sort(list);
        return list;
    }

    public static List<Lotto> generateLottos(String input) {
        Validator.isNotNumber(input);
        Validator.isNotDivide(input);
        return IntStream.range(0, lottoCount(input))
                .mapToObj(i -> new Lotto(NumberGenerator.generateRandomNumbers()))
                .collect(Collectors.toList());
    }

    public static List<Integer> generateWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    public static int lottoCount(String input) {
        return Integer.parseInt(input) / 1000;
    }
}
