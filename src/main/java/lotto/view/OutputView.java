package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.Map;

public class OutputView {

    public static void printTickets(LottoTicket ticket) {
        System.out.println();
        System.out.println(ticket.getSize() + "개를 구매했습니다.");
        ticket.getLottos().forEach(l -> System.out.println(l.getNumbers()));
    }

    public static void printResult(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> results = result.getResults();
        System.out.printf("3개 일치 (5,000원) - %d개%n", results.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", results.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", results.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", results.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", results.get(Rank.FIRST));

        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.getProfitRate());
    }
}
