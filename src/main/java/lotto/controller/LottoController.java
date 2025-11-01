package lotto.controller;

import lotto.Lotto;
import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ErrorHandler;

import java.util.List;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        try {
            int amount = InputView.readPurchaseAmount();

            lottoService.purchase(amount);
            LottoTicket ticket = lottoService.getTickets();
            OutputView.printTickets(ticket);

            List<Integer> winningNumbers = InputView.readWinningNumbers();
            int bonusNumber = InputView.readBonusNumber();

            WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
            LottoResult result = lottoService.calculateResult(ticket, winningLotto);

            OutputView.printResult(result);

        } catch (IllegalArgumentException e) {
            ErrorHandler.printError(e.getMessage());
            run();
        }
    }
}
