package lotto.domain;

import lotto.Lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @Test
    void 여러개의_로또를_정상적으로_저장한다() {
        Lotto l1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto l2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        LottoTicket ticket = new LottoTicket(List.of(l1, l2));

        assertThat(ticket.getLottos()).hasSize(2);
        assertThat(ticket.getSize()).isEqualTo(2);
    }

    @Test
    void 로또리스트가_비어있으면_getSize는_0이다() {
        LottoTicket empty = new LottoTicket(List.of());
        assertThat(empty.getSize()).isZero();
    }
}
