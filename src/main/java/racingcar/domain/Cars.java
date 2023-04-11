package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(int users) {
        for (int i = 0; i < users; i++) {
            this.cars.add(Car.create());
        }
    }

    public void race(NumberGenerator generator) {
        for (Car car : cars) {
            int number = generator.generator();
            car.move(number);
        }
    }

    public List<Position> positions() {
        List<Position> positions = new ArrayList<>();

        for (Car car : cars) {
            positions.add(car.position());
        }

        return positions;
    }
}
