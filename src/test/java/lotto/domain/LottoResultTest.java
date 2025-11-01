package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    @Test
    void 수익률_정상_계산() {
        LottoTicket ticket = new LottoTicket(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));
        WinningLotto win = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        LottoResult result = new LottoResult(ticket, win);

        assertThat(result.getResults().get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getProfitRate()).isGreaterThan(100.0);
    }
}
