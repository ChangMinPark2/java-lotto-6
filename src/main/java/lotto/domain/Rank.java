package lotto.domain;

public enum Rank {
    MATCH_0(0, 0),
    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_5_BONUS(5, 30000000),
    MATCH_6(6, 2000000000);

    private final int matchCount;
    private final int winningAmount;

    Rank(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
