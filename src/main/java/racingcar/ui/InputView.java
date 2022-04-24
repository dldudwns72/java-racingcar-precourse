package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.exception.domain.CarNameException;
import racingcar.exception.ui.AttemptCountEmptyException;
import racingcar.exception.ui.AttemptCountTypeException;

public class InputView {
    private static final String INPUT_CARS_MESSAGE = "경주할자동차이름(이름은쉼표(,)기준으로구분)";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 회수";
    private static final int ATTEMPT_COUNT_INIT = 0;
    private static final int ASCII_CODE_NUMBER_ZERO = 48;
    private static final int ASCII_CODE_NUMBER_NINE = 57;

    public static Cars racing() {
        Racing racing = new Racing(createCars(), inputAttemptCount());
        return racing.start();
    }

    public static Cars createCars() {
        try {
            System.out.println(INPUT_CARS_MESSAGE);
            String inputs = Console.readLine();
            return new Cars(inputs);
        } catch (CarNameException e) {
            System.out.println(e.getMessage());
            return createCars();
        }
    }

    private static Integer inputAttemptCount() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        String attemptCount = Console.readLine();

        try {
            validateAttemptCountType(attemptCount);
            return Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputAttemptCount();
        }
    }

    private static void validateAttemptCountType(String attemptCount) {
        if (attemptCount.isEmpty()) {
            throw new AttemptCountEmptyException();
        }

        for (int attemptCountInit = ATTEMPT_COUNT_INIT; attemptCountInit < attemptCount.length(); attemptCountInit++) {
            validateAttemptCountTypeOfNumber(attemptCount.charAt(attemptCountInit));
        }
    }

    private static void validateAttemptCountTypeOfNumber(char attemptCount) {
        if (attemptCount < ASCII_CODE_NUMBER_ZERO || attemptCount >= ASCII_CODE_NUMBER_NINE) {
            throw new AttemptCountTypeException();
        }
    }

}
