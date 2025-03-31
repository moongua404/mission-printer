package mission.model;

import java.util.List;
import mission.interfaces.PrintInterface;
import mission.utils.Utility;

public class Printer {
    private static final int MAX_INK = 1000;

    PrintInterface printInterface;
    int ink;

    public Printer(PrintInterface printInterface) {
        this.printInterface = printInterface;
        ink = MAX_INK;
    }

    public int getMaxInk() {
        return MAX_INK;
    }

    public int getInk() {
        return ink;
    }

    public void setInk() {
        this.ink = MAX_INK;
    }

    public void print(List<String> lines) {
        lines.forEach(line -> {
            int consume = Utility.countNonWhitespaceChars(line);
            if (consume > ink) {
                lastPrint(line);
                throw new IllegalStateException("잉크가 부족해 출력이 중단되었습니다.");
            }
            ink -= consume;
            printInterface.print(line);
        });
    }

    public void lastPrint(String line) {
        printInterface.print(Utility.substringUntilNthChar(line, '◼', ink));
        ink = 0;
    }
}
