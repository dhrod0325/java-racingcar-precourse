package racing.model;

import racing.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingInfo {
    private final List<Car> carList = new ArrayList<>();
    private int tryCount;

    public void parseCarList(String carNames) {
        String[] splitCarNames = carNames.split(",");

        for (String carName : splitCarNames) {
            this.carList.add(new Car(carName));
        }
    }

    public void parseTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getTryCount() {
        return tryCount;
    }
}
