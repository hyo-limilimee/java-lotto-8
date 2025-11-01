package lotto.domain;

import lotto.Lotto;

import java.util.*;

public class LottoResult {
    private final Map<Rank, Integer> results = new EnumMap<>(Rank.class);
    private final double profitRate;

    public LottoResult(LottoTicket ticket, WinningLotto winningLotto) {
        Arrays.stream(Rank.values()).forEach(r -> results.put(r, 0));

        int totalPrize = 0;
        for (Lotto lotto : ticket.getLottos()) {
            Rank rank = winningLotto.match(lotto);
            results.put(rank, results.get(rank) + 1);
            totalPrize += rank.getPrize();
        }

        int spent = ticket.getSize() * 1000;
        this.profitRate = Math.round(((double) totalPrize / spent * 1000)) / 10.0;
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
