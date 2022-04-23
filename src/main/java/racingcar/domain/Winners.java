package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private static final String DELIMITER = ",";

    private Cars cars;
    private List<Winner> winners;

    public Winners(Cars racingFinishCars) {
        winners = new ArrayList<>();
        this.cars = racingFinishCars;
        determineWinner();
    }

    private void determineWinner() {
        int maxMoveCount = getMaxMoveCount();

        for (int index = 0; index < cars.getSize(); index++) {
            Car car = cars.getCar(index);
            comparePosition(car, maxMoveCount);
        }
    }

    private int getMaxMoveCount() {
        int winnerMoveCount = 0;
        for (int index = 0; index < cars.getSize(); index++) {
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

        String message = String.join(DELIMITER, stringWinner);

        return message;
    }

}
