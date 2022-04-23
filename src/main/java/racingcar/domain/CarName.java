package racingcar.domain;

public class CarName {

    private static final Integer MIN_CAR_NAME_LENGTH = 1;
    private static final Integer MAX_CAR_NAME_LENGTH = 5;

    private static final String ERROR_NAME_LENGTH_MESSAGE = "[ERROR] 이름은 1자 이상 5자 미만이여야 합니다.";

    private String name;

    public CarName(String name){
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if(name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH ) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
