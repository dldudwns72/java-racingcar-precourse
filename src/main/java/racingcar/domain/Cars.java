package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MIN_CAR_COUNT = 2;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final String SPACING_WARD = "\n";

    private static final String MIN_CAR_COUNT_ERROR_MESSAGE = "[Error] 자동차는 두 대 이상 존재해야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[Error] 자동차 이름은 중복될 수 없습니다.";

    private List<Car> cars;

    public Cars(String StringCars) {
        String[] splitCars = StringCars.split(CAR_NAME_DELIMITER);
        List<Car> cars = new ArrayList<>();
        for (String carName : splitCars) {
            validateDuplicate(cars,carName);
            cars.add(new Car(new CarName(carName)));
        }
        validateNumberOfCars(cars);
        this.cars = cars;
    }

    private void validateNumberOfCars(List<Car> cars) {
        if (cars.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(MIN_CAR_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Car> cars, String carName) {
        for (Car car : cars){
            compareCar(car,carName);
        }
    }

    private void compareCar(Car car,String carName){
        Car generatedCar = new Car(new CarName(carName));
        if (car.isEqual(generatedCar)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public String printCars() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            car.move(randomNumber);
            String result = car.print() + SPACING_WARD;
            sb.append(result);
        }
        return sb.toString();
    }

    public int getSize() {
        return cars.size();
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

}
