package racingcar.domain;

public class CarPosition {
    private Integer position;

    public CarPosition(Integer position){
        validate(position);
        this.position = position;
    }

    private void validate(Integer position) {
        if(position < 0){
            throw new IllegalArgumentException("자동차는 후진할 수 없습니다.");
        }
    }

    public Integer getPosition() {
        return position;
    }
}
