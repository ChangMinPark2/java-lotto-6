package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Discriminator {
    private final Map<Rank, Integer> result = new HashMap<>();

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public void howManyLotto(Lottos lottos, WinningNumbers winningNumbers, String bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = checkRank(lotto, winningNumbers, bonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public double totalProfit(String inputPrice) {
        int totalAmount = 0;

        for (Rank rank : result.keySet()) {
            totalAmount += rank.getWinningAmount();
        }

        return (double) totalAmount / (double) Integer.parseInt(inputPrice) * 100;

    }

    public Rank checkRank(Lotto lotto, WinningNumbers winningNumbers, String bonusNumber) {
        long matchCount = lotto.getNumbers()
                .stream()
                .filter(winningNumbers.getWinningNumbers()::contains)
                .count();

        return findRank(matchCount, lotto, bonusNumber);
    }

    public Rank findRank(long matchCount, Lotto lotto, String bonusNumber) {
        if (matchCount == Rank.MATCH_5_BONUS.getMatchCount() && lotto.contains(Integer.parseInt(bonusNumber))) {
            return Rank.MATCH_5_BONUS;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(Rank.MATCH_0);
    }
}
