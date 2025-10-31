package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public static void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }

        for (int num : numbers) {
            if (num < 1 || num > 45)
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
    }
}