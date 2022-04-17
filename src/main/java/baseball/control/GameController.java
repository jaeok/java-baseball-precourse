package baseball.control;

import baseball.model.Game;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private Game game;
    private GameView gameView;

    public GameController(Game game, GameView gameView) {
        this.game = game;
        this.gameView = gameView;
    }

    private void shuffle() {
        List list = new ArrayList<Integer>();
        List selected = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) list.add(i);
        for (int i = 0; i < 3; i++) {
            selected.add(Randoms.pickNumberInRange(1, 9));
        }
        game.setSelected(selected);
    }

    private void getInput() {
        gameView.print();
        String input = Console.readLine();
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("입력값을 확인해주세요");
        }
        try {
            game.setInput(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("입력값을 확인해주세요");
        }
    }

    private void renew() {
        gameView.renew();
        String input = Console.readLine();
        if (input == null) {
            throw new IllegalArgumentException("입력값을 확인해주세요");
        }
        try {
            game.setIsContinue(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("입력값을 확인해주세요");
        }
    }


    private int test() {
        int strikeCnt = 0, ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            strikeCnt += getStrikeCnt(i);
            ballCnt += getBallCnt(i);
        }
        gameView.result(ballCnt, strikeCnt);
        if (strikeCnt == 3) return 1;
        return 0;
    }

    private int getStrikeCnt(int idx) {
        int temp1 = game.getInput().charAt(idx) - '0';
        int temp2 = game.getSelected().get(idx);
        if (temp1 == temp2) {
            return 1;
        }
        return 0;
    }

    private int getBallCnt(int idx) {
        int temp1 = game.getInput().charAt(idx) - '0';
        int temp2 = game.getSelected().get(idx);
        if (temp1 != temp2 && game.getSelected().contains(temp1)) {
            return 1;
        }
        return 0;
    }

    public void start() {
        int isOver = 0;
        shuffle();
        while (isOver == 0) {
            getInput();
            isOver = test();
        }
        renew();
    }

}
