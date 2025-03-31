package mission;

import mission.controller.PrinterController;

public class Application {
    public static void main(String[] args) {
        //Todo: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        PrinterController printerController = appConfig.printerController();

        printerController.run();
    }
}
