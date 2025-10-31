package lotto.utils;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class ConverterTest {

    @Test
    void 문자열을_숫자리스트로_변환() {
        List<Integer> list = Converter.toIntegerList("1, 2, 3, 4, 5, 6");
        assertThat(list).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 공백이나_null이면_예외() {
        assertThatThrownBy(() -> Converter.toIntegerList(" "))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Converter.toIntegerList(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아니면_예외() {
        assertThatThrownBy(() -> Converter.toIntegerList("1,2,a,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }
}
