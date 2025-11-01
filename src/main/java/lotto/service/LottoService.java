package lotto.service;

import lotto.Lotto;
import lotto.domain.*;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private LottoTicket ticket;

    public void purchase(int amount) {
        int count = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream().sorted().collect(Collectors.toList());
            lottos.add(new Lotto(numbers));
        }
        ticket = new LottoTicket(lottos);
    }

    public LottoTicket getTickets() {
        return ticket;
    }

    public LottoResult calculateResult(LottoTicket ticket, WinningLotto winningLotto) {
        return new LottoResult(ticket, winningLotto);
    }
}
