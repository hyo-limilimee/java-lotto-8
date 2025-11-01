package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Converter;
import lotto.utils.Validator;

import java.util.List;

public class InputView {
    private static final String INPUT_MESSAGE_PURCHASE_INPUT = "구입금액을 입력해 주세요.";
    private static final String ERROR_PURCHASE_AMOUNT_NUMBER = "구입 금액은 숫자여야 합니다.";
    private static final String INPUT_MESSAGE_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String ERROR_BONUS_NUMBER = "보너스 번호는 숫자여야 합니다.";
    private static final String ERROR_BONUS_NUMBER_RANGE = "보너스 번호는 1부터 45 사이여야 합니다.";


    public static int readPurchaseAmount() {
        System.out.println(INPUT_MESSAGE_PURCHASE_INPUT);
        String input = Console.readLine();

        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_NUMBER);
        }

        Validator.validateAmount(amount);
        return amount;
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(INPUT_MESSAGE_WINNING_NUMBER);
        String input = Console.readLine();
        List<Integer> numbers = Converter.toIntegerList(input);
        Validator.validateNumbers(numbers);
        return numbers;
    }

    public static int readBonusNumber() {
        System.out.println(INPUT_MESSAGE_BONUS_NUMBER);
        String input = Console.readLine();
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER);
        }

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_RANGE);
        }

        return number;
    }
}
