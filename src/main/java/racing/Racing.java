package racing;

import racing.model.Car;
import racing.model.RacingInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Racing {
    private final RacingInfo racingInfo;

    public Racing(RacingInfo racingInfo) {
        this.racingInfo = racingInfo;
    }

    public void run(racing.Racing.Callback callback) {
        int tryCount = racingInfo.getTryCount();
        List<Car> carList = racingInfo.getCarList();

        for (int i = 0; i < tryCount; i++) {
            carList.forEach(car -> {
                car.forward();
                callback.onCarMoved(car);
            });

            callback.onAllCarMoved();
        }
    }

    public String getWinnerNames() {
        return getWinners()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    private List<Car> getWinners() {
        return getRankData()
                .lastEntry()
                .getValue();
    }

    private NavigableMap<Integer, List<Car>> getRankData() {
        NavigableMap<Integer, List<Car>> result = new TreeMap<>();

        racingInfo.getCarList().forEach(car -> {
            List<Car> carList = result.getOrDefault(car.getPosition(), new ArrayList<>());
            carList.add(car);
            result.put(car.getPosition(), carList);
        });

        return result;
    }

    public interface Callback {
        void onCarMoved(Car car);

        void onAllCarMoved();
    }
}
