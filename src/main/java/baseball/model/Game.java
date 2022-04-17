package baseball.model;

import java.util.List;

public class Game {
    private List<Integer> selected;
    private String input;
    private String isContinue;

    public Game() {
        isContinue = "1";
    }


    public List<Integer> getSelected() {
        return selected;
    }

    public void setSelected(List<Integer> selected) {
        this.selected = selected;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getIsContinue() {
        return isContinue;
    }

    public void setIsContinue(String isContinue) {
        this.isContinue = isContinue;
    }
}
