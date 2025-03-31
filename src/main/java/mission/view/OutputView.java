package mission.view;

import java.util.List;

public class OutputView {
    public void printPrintout(List<String> printout) {
        printout.forEach(System.out::println);
    }

    public void printerExecuteMessage() {
        System.out.println("프린터를 실행합니다.");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printEndMessage() {
        System.out.println("출력이 완료되었습니다.");
    }

    public void showInk(int ink, int max) {
        System.out.printf("잉크 잔량 : %d, %d%n", ink, max);
    }

    public void chargedInk() {
        System.out.println("잉크를 교체하였습니다.");
    }

    public void printTerminateMessage() {
        System.out.println("프로그램을 종료합니다.");
    }
}
