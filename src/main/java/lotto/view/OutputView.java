package lotto.view;

import lotto.domain.Discriminator;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.Map;

public final class OutputView {
    private OutputView() {
    }

    public static void lottoList(Lottos lottos) {
        System.out.println("\n" + lottos.getLottoCount() + "개를 구매했습니다.");
        System.out.println(lottos + "\n");
    }

    public static void resultPrint(Discriminator discriminator, String inputPrice) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> result = discriminator.getResult();
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault(Rank.MATCH_3, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault(Rank.MATCH_4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault(Rank.MATCH_5, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault(Rank.MATCH_5_BONUS,
                0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault(Rank.MATCH_6, 0) + "개");
        System.out.println("총 수익률은 " + discriminator.totalProfit(inputPrice) + "%입니다.");
    }

}
