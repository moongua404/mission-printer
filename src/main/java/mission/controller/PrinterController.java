package mission.controller;

import mission.ProgramTerminateException;
import mission.interfaces.PrintInterface;
import mission.model.AsciiGenerator;
import mission.model.Printer;
import mission.utils.Utility;
import mission.utils.Validator;
import mission.view.InputView;
import mission.view.OutputView;

public class PrinterController {
    InputView inputView;
    OutputView outputView;
    AsciiGenerator asciiGenerator;
    Printer printer;

    public PrinterController(InputView inputView, OutputView outputView) {
        class PrintInterfaceImpl implements PrintInterface {
            @Override
            public void print(String body) {
                outputView.printMessage(body);
            }
        }

        this.inputView = inputView;
        this.outputView = outputView;
        asciiGenerator = new AsciiGenerator();
        printer = new Printer(new PrintInterfaceImpl());
    }

    public void run() {
        outputView.printerExecuteMessage();
        while (true) {
            try {
                execute();
            } catch (ProgramTerminateException exception) {
                break;
            } catch (Exception exception) {
                outputView.printMessage(exception.getMessage());
            }
        }
        outputView.printTerminateMessage();
    }

    private void execute() {
        int selected = inputView.getFeatureSelection();
        if (selected == 1) {
            print();
            return;
        }
        if (selected == 2) {
            outputView.showInk(printer.getInk(), printer.getMaxInk());
            return;
        }
        if (selected == 3) {
            printer.setInk();
            outputView.chargedInk();
            return;
        }
        if (selected == 4) {
            throw new ProgramTerminateException();
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
    }

    private void print() {
        String line = inputView.getNumberLine();
        Validator.composeNumeric(line);

        int length = inputView.getLineLength();
        Validator.positiveInteger(length);

        printer.print(asciiGenerator.generateAsciiPrintout(Utility.stringToIntegers(line), length));
    }
}
