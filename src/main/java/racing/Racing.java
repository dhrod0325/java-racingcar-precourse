package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Racing {
    private final RacingInfo racingInfo;

    public Racing(RacingInfo racingInfo) {
        this.racingInfo = racingInfo;
    }

    public void run(RacingCallback callback) {
        int tryCount = racingInfo.getTryCount();
        List<Car> carList = racingInfo.getCarList();

        for (int i = 0; i < tryCount; i++) {
            carList.forEach(car -> {
                car.move();
                callback.onCarMoved(car);
            });

            callback.onAllCarMoved();
        }
    }

    public String getWinnerNames() {
        List<String> results = new ArrayList<>();
        getRankData().lastEntry().getValue().forEach(car -> results.add(car.getName()));
        return String.join(",", results);
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
}
