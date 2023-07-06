package racing.model;

import racing.exception.IllegalRandomNumberException;
import racing.generator.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MIN_MOVABLE = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<CarVO> getCars() {
        return cars.stream()
                .map(car -> new CarVO(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<CarVO> nextStep(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            goForwardIfMovable(car, numberGenerator);
        }
        return this.getCars();
    }

    private void goForwardIfMovable(Car car, NumberGenerator numberGenerator) {
        if (isMovable(numberGenerator.generate())) {
            car.goForward();
        }
    }

    private boolean isMovable(int value) {
        validateNumber(value);
        return MIN_MOVABLE <= value;
    }

    private void validateNumber(int value) {
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new IllegalRandomNumberException();
        }
    }

    public List<CarVO> getWinners() {
        int maxValue = cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(-1);
        return cars.stream()
                .filter(car -> car.getPosition() == maxValue)
                .map(car -> new CarVO(car.getName(), car.getPosition()))
                .collect(Collectors.toList());

    }

}