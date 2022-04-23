package racingcar.ui;

import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class OutputView {

    private static final String PRINT_WINNERS_PREFIX = "최종 우승자는 ";
    private static final String PRINT_WINNERS_SUFFIX = " 입니다.";

    public static void finishRacing(Cars cars) {
        Winners winners = new Winners(cars);
        String winnerToString = winners.printWinners();
        String printWinners = PRINT_WINNERS_PREFIX + winnerToString + PRINT_WINNERS_SUFFIX;
        System.out.print(printWinners);
    }
}
