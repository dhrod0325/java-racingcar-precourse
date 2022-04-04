package view;

import racing.RacingInfo;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    private final RacingInfo racingInfo = new RacingInfo();

    public InputView(Scanner scanner) throws Exception {
        this.scanner = scanner;

        inputCarNames();

        inputTryCount();
    }

    public RacingInfo getRacingInfo() {
        return racingInfo;
    }

    private void inputCarNames() throws Exception {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = scanner.next();

        if (!carNames.contains(",")) {
            throw new Exception("[ERROR] 자동차이름은 ,로 구분 하여야한다");
        }

        racingInfo.parseCarList(carNames);
    }

    private void inputTryCount() throws Exception {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            int tryCount = scanner.nextInt();
            racingInfo.parseTryCount(tryCount);
        } catch (Exception e) {
            throw new Exception("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }
}
