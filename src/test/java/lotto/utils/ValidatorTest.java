package lotto.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @Test
    void 금액이_1000단위가_아니면_예외() {
        assertThatThrownBy(() -> Validator.validateAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_번호_존재시_예외() {
        assertThatThrownBy(() -> Validator.validateNumbers(List.of(1, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위_벗어난_번호_예외() {
        assertThatThrownBy(() -> Validator.validateNumbers(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
