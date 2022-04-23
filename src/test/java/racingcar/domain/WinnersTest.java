package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    Cars cars;
    Car leeCar = new Car(new CarName("lee"));
    Car kimCar = new Car(new CarName("kim"));
    Car parkCar = new Car(new CarName("park"));

    @BeforeEach
    void setUp(){
        cars = new Cars(Arrays.asList(leeCar,kimCar,parkCar));
    }

    @Test
    @DisplayName("우승자가 한명일 경우")
    void oneWinner(){
        leeCar.move(5);
        kimCar.move(3);
        parkCar.move(3);

        Winners winners = new Winners(cars);
        String result = winners.printWinners();
        assertThat(result).isEqualTo("lee");
    }

    @Test
    @DisplayName("우승자가 두명 이상 일 경우")
    void moreTwoWinner(){
        leeCar.move(5);
        kimCar.move(5);
        parkCar.move(5);

        Winners winners = new Winners(cars);
        String result = winners.printWinners();
        assertThat(result).isEqualTo("lee,kim,park");
    }


}