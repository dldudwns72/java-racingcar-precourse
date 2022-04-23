package racingcar.domain;

public class CarPosition {
    private static final String PRINT_POSITION_WORD = "-";
    private static final String MIN_POSITION_ERROR_MESSAGE = "[ERROR] 자동차는 후진할 수 없습니다.";
    private int position;

    public CarPosition(Integer position){
        validate(position);
        this.position = position;
    }

    private void validate(Integer position) {
        if(position < 0){
            throw new IllegalArgumentException(MIN_POSITION_ERROR_MESSAGE);
        }
    }

    public void addPosition(){
        position++;
    }

    public String printPosition(){
        StringBuilder sb = new StringBuilder();
        for(int index=0;index < position; index++){
            sb.append(PRINT_POSITION_WORD);
        }

        return sb.toString();
    }

    public int getPosition() {
        return position;
    }
}
