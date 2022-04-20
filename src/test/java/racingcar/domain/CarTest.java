package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 정보 반환")
    void getCarData(){
        Car car = new Car(new CarName("tesla"),new CarPosition(1));

        assertThat(car.getName()).isEqualTo("tesla");
        assertThat(car.getPosition()).isEqualTo(1);
    }
}