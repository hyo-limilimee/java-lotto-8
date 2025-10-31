package lotto.domain;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    void 여섯개_일치시_1등() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void 다섯개_보너스포함시_2등() {
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void 세개_일치시_5등() {
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
    }
}
