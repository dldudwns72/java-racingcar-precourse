package racingcar.domain;

public class Winner {

    private static final String WINNER_EMPTY_ERROR_MESSAGE = "[ERROR] 우승자는 한 명 이상 존재해야 합니다.";
    private String winner;

    public Winner(String winner) {
        validate(winner);
        this.winner = winner;
    }

    private void validate(String winner) {
        if(winner.isEmpty()){
            throw new IllegalArgumentException(WINNER_EMPTY_ERROR_MESSAGE);
        }
    }

    public String getWinner() {
        return winner;
    }

}
