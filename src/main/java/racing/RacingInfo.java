package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingInfo {
    private final List<Car> carList = new ArrayList<>();
    private final int tryCount;

    public RacingInfo(String carNames, String tryCount) {
        this.carList.addAll(this.parseCarList(carNames));
        this.tryCount = Integer.parseInt(tryCount);
    }

    private List<Car> parseCarList(String carNames) {
        List<Car> result = new ArrayList<>();
        String[] splitCarNames = carNames.split(",");

        for (String carName : splitCarNames) {
            result.add(new Car(carName));
        }

        return result;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getTryCount() {
        return tryCount;
    }
}
