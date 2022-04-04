package racing.view;

import racing.Racing;
import racing.model.Car;

public class OutputView {
    private final Racing racing;

    public OutputView(InputView inputView) {
        this.racing = new Racing(inputView.getRacingInfo());
    }

    public void printRacingResult() {
        System.out.println("실행결과");

        racing.run(outputRacingCallback);

        System.out.printf("최종우승 : %s%n", racing.getWinnerNames());
    }

    private final Racing.Callback outputRacingCallback = new Racing.Callback() {
        @Override
        public void onCarMoved(Car car) {
            System.out.println(car.getStatus());
        }

        @Override
        public void onAllCarMoved() {
            System.out.println();
        }
    };
}
