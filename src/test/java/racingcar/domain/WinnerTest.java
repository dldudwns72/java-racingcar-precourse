package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.domain.WinnerException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerTest {

    @Test
    @DisplayName("우승자 이름 확인")
    void getWinner(){
        Winner winner = new Winner("lee");
        assertThat(winner.getWinner()).isEqualTo("lee");
    }

    @Test
    @DisplayName("우승자가 없으면 예외 발생")
    void emptyWinner(){
        assertThatThrownBy(() ->{
            Winner winner = new Winner("");
        }).isInstanceOf(WinnerException.class)
                .hasMessageContaining("우승자는 한 명 이상 존재");
    }

}
