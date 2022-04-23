package racingcar.domain;

public class Racing {

    private Cars cars;
    private int attemptCount;

    public Racing(Cars cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
        start();
    }

    private void start() {
        for (int startCount = 0; startCount < attemptCount; startCount++) {
            System.out.print(cars.printCars());
            System.out.print("\n");
        }
    }

}
