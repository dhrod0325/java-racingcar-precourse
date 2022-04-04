package racing.model;

import utils.RandomUtils;

public class Car {
    enum Status {
        MOVE, STOP
    }

    private static final int MOVE_ABLE_COUNT = 4;
    private static final int MIN_MOVE = 0;
    private static final int MAX_MOVE = 10;

    private final String name;
    private int position = 0;

    private Status status = Status.MOVE;

    public Car(String name) {
        this.name = name;
    }

    public void forward() {
        if (isStop()) return;

        if (!isMoveAble()) {
            status = Status.STOP;
        }

        this.move();
    }

    public String getStatus() {
        StringBuilder out = new StringBuilder();
        out.append(name).append(" : ");

        for (int i = 0; i < position; i++) {
            out.append("-");
        }

        return out.toString();
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    private void move() {
        position += 1;
    }

    private boolean isMoveAble() {
        int move = RandomUtils.nextInt(MIN_MOVE, MAX_MOVE);
        return move >= MOVE_ABLE_COUNT;
    }

    private boolean isStop() {
        return status == Status.STOP;
    }
}
