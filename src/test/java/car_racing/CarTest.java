package car_racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.NumberGeneratorByInputNumber;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("car의 처음 moveCount 초기값은 0이여야 한다.")
    void car_초기화() {
        // when
        Car car = new Car("pobi", new NumberGeneratorByInputNumber(0));
        // then
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("랜덤 값이 4이하일 경우 car는 움직이지 않는다.")
    void car_멈춤() {
        // when
        Car car = new Car("pobi", new NumberGeneratorByInputNumber(3));
        car.moveOrStop();

        // then
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("랜덤 값이 4초과일 경우 car는 움직인다.")
    void car_움직임() {
        //when
        Car car = new Car("pobi", new NumberGeneratorByInputNumber(5));
        car.moveOrStop();

        //then
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }


}