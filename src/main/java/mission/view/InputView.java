package mission.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getFeatureSelection() {
        try {
            System.out.println("사용할 기능을 입력해주세요. 1) 출력, 2) 잉크 잔량 확인, 3) 잉크 교체, 4) 프로그램 종료");
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. ");
        }
    }

    public String getNumberLine() {
        try {
            System.out.println("출력할 숫자를 입력해주세요.");
            return scanner.nextLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. ");
        }
    }

    public int getLineLength() {
        try {
            System.out.println("용지 크기를 입력해주세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. ");
        }
    }
}
