package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    void 보너스번호_중복시_예외() {
        Lotto win = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(win, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 일치_개수에_따른_Rank_정확() {
        Lotto win = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto mine = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        WinningLotto w = new WinningLotto(win, 7);
        assertThat(w.match(mine)).isEqualTo(Rank.FIFTH);
    }
}
