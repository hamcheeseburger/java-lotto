package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        PurchasePrice purchasePrice = new PurchasePrice(InputView.requestPurchasePriceInput());
        int lottoCount = purchasePrice.calculateLottoCount();
        OutputView.printLottoCount(lottoCount);
        Lottos lottos = new Lottos(LottoGenerator.generate(lottoCount));
        OutputView.printLottos(lottos);

        WinningBalls winningBalls = new WinningBalls(InputView.requestWinningNumbersInput());
        BonusBall bonusBall = new BonusBall(InputView.requestBonusNumberInput(), winningBalls);

        Results results = new Results(lottos, winningBalls, bonusBall);
        OutputView.printLottoResult(results, purchasePrice);
    }
}