package racingcar.ui;

import racingcar.domain.Cars;

public class Racing {

    private Cars cars;
    private int attemptCount;

    public Racing(Cars cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public Cars start() {
        for (int startCount = 0; startCount < attemptCount; startCount++) {
            System.out.print(cars.printCars());
            System.out.print("\n");
        }

        return cars;
    }

}
