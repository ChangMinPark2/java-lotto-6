package lotto.domain;

import lotto.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;
    private final int lottoCount;

    public Lottos(List<Lotto> lottos, int lottoCount) {
        this.lottos = lottos;
        this.lottoCount = lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
