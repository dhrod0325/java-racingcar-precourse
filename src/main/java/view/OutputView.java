package view;

import racing.Car;
import racing.Racing;
import racing.RacingCallback;

public class OutputView {
    private final Racing racing;

    public OutputView(InputView inputView) {
        this.racing = new Racing(inputView.getRacingInfo());
    }

    public void printRacingResult() {
        System.out.println("실행결과");

        racing.run(new RacingCallback() {
            @Override
            public void onCarMoved(Car car) {
                printStatus(car);
            }

            @Override
            public void onAllCarMoved() {
                System.out.println();
            }
        });

        System.out.printf("최종우승 : %s%n", racing.getWinnerNames());
    }

    public void printStatus(Car car) {
        StringBuilder out = new StringBuilder();
        out.append(car.getName()).append(" : ");

        for (int i = 0; i < car.getPosition(); i++) {
            out.append("-");
        }

        System.out.println(out);
    }
}
