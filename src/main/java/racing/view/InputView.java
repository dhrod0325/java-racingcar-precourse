package racing.view;

import racing.exception.RacingException;
import racing.model.RacingInfo;

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
        racingInfo.parseCarList(parseCarNames(scanner.next()));
    }

    private String parseCarNames(String carNames) throws Exception {
        if (carNames.trim().isEmpty()) {
            throw new RacingException("자동차 이름을 입력하세요");
        }

        if (carNames.length() > 5) {
            throw new RacingException("자동차 이름은 5글자 이상 입력할 수 없습니다");
        }

        return carNames;
    }

    private void inputTryCount() throws Exception {
        System.out.println("시도할 회수는 몇회인가요?");
        racingInfo.parseTryCount(parseTryCount(scanner.next()));
    }

    private int parseTryCount(String tryCountStr) throws Exception {
        try {
            return Integer.parseInt(tryCountStr);
        } catch (Exception e) {
            throw new RacingException("시도 횟수는 숫자여야 한다.");
        }
    }
}
