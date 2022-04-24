package racingcar.domain;

import racingcar.exception.domain.WinnerException;

public class Winner {

    private String winner;

    public Winner(String winner) {
        validate(winner);
        this.winner = winner;
    }

    private void validate(String winner) {
        if(winner.isEmpty()){
            throw new WinnerException();
        }
    }

    public String getWinner() {
        return winner;
    }

}
