package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @Test
    void 정상_범위_번호_생성() {
        LottoNumber num = new LottoNumber(15);
        assertThat(num.getNumber()).isEqualTo(15);
    }

    @Test
    void 범위를_벗어나면_예외() {
        assertThatThrownBy(() -> new LottoNumber(50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45");
    }
}
