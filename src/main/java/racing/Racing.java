package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Racing {
    private final RacingInfo racingInfo;

    public Racing(String carNames, String tryCount) {
        this.racingInfo = new RacingInfo(carNames, tryCount);
    }

    public void startGame() {
        int tryCount = racingInfo.getTryCount();
        List<Car> carList = racingInfo.getCarList();

        for (int i = 0; i < tryCount; i++) {
            carList.forEach(car -> {
                car.move();
                car.printStatus();
            });

            System.out.println();
        }
    }

    public void endGame() {
        System.out.printf("최종우승 : %s%n", getWinnerNames());
    }

    private String getWinnerNames() {
        List<String> results = new ArrayList<>();

        getRankData().lastEntry().getValue().forEach(car -> {
            results.add(car.getName());
        });

        return String.join(",", results);
    }

    private NavigableMap<Integer, List<Car>> getRankData() {
        NavigableMap<Integer, List<Car>> result = new TreeMap<>();

        for (Car car : racingInfo.getCarList()) {
            List<Car> carList = result.getOrDefault(car.getPosition(), new ArrayList<>());
            carList.add(car);
            result.put(car.getPosition(), carList);
        }

        return result;
    }
}
