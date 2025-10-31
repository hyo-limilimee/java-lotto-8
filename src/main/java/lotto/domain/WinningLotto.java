package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;
    static final String ERROR_DUPLICATE_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validateBonus(winningNumbers.getNumbers(), bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS_NUMBER);
        }
    }

    public Rank match(Lotto lotto) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        return Rank.of(matchCount, matchBonus);
    }
}
