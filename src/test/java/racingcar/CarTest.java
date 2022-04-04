package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.Car;
import racing.Racing;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    public void 자동차전진테스트() throws Exception {
        car.move(1);

        Assertions.assertEquals(car.getPosition(), 1);
    }

    @Test
    public void 자동차전진오류테스트() {
        Exception exception = assertThrows(Exception.class, () -> {
            car.move(-1);
        });

        Assertions.assertEquals("전진,스톱만 가능합니다", exception.getMessage());
    }

    @Test
    public void 자동차랜덤전진테스트() {
        for (int i = 0; i < 10; i++) {
            car.move();
        }

        Assertions.assertTrue(car.getPosition() >= 0);
    }

    @Test
    public void 경주테스트() {
        Racing racing = new Racing("pobi,woni,jun", "5");
        racing.startGame();
    }
}
