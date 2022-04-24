package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;

public class InputView {
    private static final String INPUT_CARS_MESSAGE = "경주할자동차이름(이름은쉼표(,)기준으로구분)";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 회수";
    private static final String ATTEMPT_COUNT_VALIDATION_EMPTY_MESSAGE = "[Error] 시도 횟수를 숫자로 입력해주세요.";
    private static final String ATTEMPT_COUNT_VALIDATION_MESSAGE = "[Error] 시도 횟수는 숫자여야합니다.";
    private static final String EMPTY_STRING = "";
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
        } catch (IllegalArgumentException e) {
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
        if (attemptCount.equals(EMPTY_STRING)) {
            throw new NumberFormatException(ATTEMPT_COUNT_VALIDATION_EMPTY_MESSAGE);
        }

        for (int i = 0; i < attemptCount.length(); i++) {
            validateAttemptCountTypeOfNumber(attemptCount.charAt(i));
        }
    }

    private static void validateAttemptCountTypeOfNumber(char attemptCount){
        if (attemptCount < ASCII_CODE_NUMBER_ZERO || attemptCount >= ASCII_CODE_NUMBER_NINE) {
            throw new NumberFormatException(ATTEMPT_COUNT_VALIDATION_MESSAGE);
        }
    }

}
