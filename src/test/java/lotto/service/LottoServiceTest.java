package lotto.service;

import lotto.Lotto;
import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    @Test
    void 금액에_비례하여_로또가_발행된다() {
        LottoService service = new LottoService();
        service.purchase(8000);

        LottoTicket ticket = service.getTickets();
        assertThat(ticket.getSize()).isEqualTo(8);
    }

    @Test
    void 로또발행시_각_번호는_6개이다() {
        LottoService service = new LottoService();
        service.purchase(1000);

        LottoTicket ticket = service.getTickets();
        assertThat(ticket.getLottos().get(0).getNumbers()).hasSize(6);
    }

    @Test
    void 당첨결과를_정상적으로_계산한다() {
        LottoService service = new LottoService();

        LottoTicket ticket = new LottoTicket(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        ));

        WinningLotto winning = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        LottoResult result = service.calculateResult(ticket, winning);

        assertThat(result.getResults().get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getProfitRate()).isGreaterThan(100.0);
    }
}
