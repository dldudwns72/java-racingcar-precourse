package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarPositionTest {

    @Test
    void createCarPosition() {
        CarPosition carPosition = new CarPosition(3);
        assertThat(carPosition.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("위치값이 0보다 작을 경우 예외 발생")
    void validatePositionUnderZero() {
        assertThatThrownBy(() -> {
            new CarPosition(-1);
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("후진");
    }

}