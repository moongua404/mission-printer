package mission;

import mission.controller.PrinterController;
import mission.model.Printer;
import mission.view.InputView;
import mission.view.OutputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public PrinterController printerController() {
        return new PrinterController(inputView(), outputView());
    }
}
