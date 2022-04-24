package racingcar.exception.domain;

import racingcar.exception.CommonException;

public class WinnerException extends CommonException {
    private static final String WINNER_EMPTY_ERROR_MESSAGE = "우승자는 한 명 이상 존재해야 합니다.";

    public WinnerException(){
        super(WINNER_EMPTY_ERROR_MESSAGE);
    }
}
