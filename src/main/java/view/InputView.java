package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputBuyMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputManualLottoTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        return scanner.nextLine();
    }

    public static void printInputManualLottoTicket() {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
    }

    public static String inputManualLottoTicket() {
        return scanner.nextLine();
    }

    public static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}