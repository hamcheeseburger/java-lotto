package view;

import domain.Money;
import domain.lotto.LottoGame;
import domain.lotto.LottoNumber;
import domain.lotto.LottoNumbers;
import domain.lotto.lottoresult.LottoRank;
import domain.lotto.lottoresult.LottoResult;
import domain.lotto.lottoresult.ResultCount;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OutputView {
    private OutputView() {
        throw new AssertionError();
    }

    public static void printMoneyFormat() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printWinnerNumbersFormat() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberFormat() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void printLottoNumbersCount(Money money) {
        System.out.println(money.countGames() + "개를 구매습니다.");
    }

    public static void printLottoGame(LottoGame lottogame) {
        for (LottoNumbers lottoNumbers : lottogame.getLottoGame()) {
            OutputView.printLottoNumbers(lottoNumbers);
        }
    }

    private static void printLottoNumbers(LottoNumbers lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(lottoNumbers.getLottoNumbers()
                .stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "))
        );
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void printResultAll(Money money, LottoResult lottoResult) {
        OutputView.printResultTitle();
        OutputView.printLottoResult(lottoResult);
        OutputView.printEarning(money.calculateEarningRate(lottoResult.calculateEarning()));
    }

    private static void printResultTitle() {
        System.out.println("\n당첨 통계");
        System.out.println("--------");
    }

    private static void printLottoResult(LottoResult lottoResult) {
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.NOTHING)
                .forEach(rank -> printRankResult(rank, lottoResult.countRank(rank)));
    }

    private static void printRankResult(LottoRank rank, ResultCount resultCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getHitCount());
        sb.append("개 일치");
        if (rank.hasBonus()) {
            sb.append(", 보너스볼 일치");
        }
        sb.append(" (");
        sb.append(rank.getWinning());
        sb.append("원)- ");
        sb.append(resultCount.toString() + "개");
        System.out.println(sb.toString());
    }

    private static void printEarning(long rating) {
        System.out.println("총 수익률은 " + rating + "%입니다.");
    }
}