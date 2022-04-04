import racing.view.InputView;
import racing.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            InputView inputView = new InputView(scanner);

            OutputView outputView = new OutputView(inputView);
            outputView.printRacingResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
