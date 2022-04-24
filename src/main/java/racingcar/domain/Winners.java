package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private static final String DELIMITER = ",";
    private static final int INIT_POSITION_COUNT = 0;
    private static final int INIT_CARS_INDEX = 0;

    private Cars cars;
    private List<Winner> winners;

    public Winners(Cars racingFinishCars) {
        winners = new ArrayList<>();

        this.cars = racingFinishCars;
        determineWinner();
    }

    private void determineWinner() {
        int maxMoveCount = getMaxMoveCount();

        for (int index = INIT_CARS_INDEX; index < cars.getSize(); index++) {
            Car car = cars.getCar(index);
            comparePosition(car, maxMoveCount);
        }
    }

    private int getMaxMoveCount() {
        int winnerMoveCount = INIT_POSITION_COUNT;
        for (int index = INIT_CARS_INDEX; index < cars.getSize(); index++) {
            Car car = cars.getCar(index);
            winnerMoveCount = Math.max(winnerMoveCount, car.getPosition());
        }
        return winnerMoveCount;
    }

    private void comparePosition(Car car, int maxMoveCount) {
        if (car.getPosition() == maxMoveCount) {
            winners.add(new Winner(car.getName()));
        }
    }

    public String printWinners(){
        List<String> stringWinner = new ArrayList<>();

        for (Winner winner : winners){
            stringWinner.add(winner.getWinner());
        }

        String printWinners = String.join(DELIMITER, stringWinner);

        return printWinners;
    }

}
