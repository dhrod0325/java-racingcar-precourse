package racing;

import utils.RandomUtils;

public class Car {
    private static final int MIN_MOVE = 0;
    private static final int MAX_MOVE = 9;

    private final String name;
    private int position = 0;

    private CarStatus status = CarStatus.MOVE;

    public Car(String name) {
        this.name = name;
    }

    public void move(int move) {
        position += move;
    }

    public void move() {
        if (isStop()) return;

        if (!isMoveAble()) {
            status = CarStatus.STOP;
        }

        this.move(1);
    }

    private boolean isMoveAble() {
        int move = RandomUtils.nextInt(MIN_MOVE, MAX_MOVE);
        return move >= 4;
    }

    private boolean isStop() {
        return status == CarStatus.STOP;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
