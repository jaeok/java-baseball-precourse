package baseball.view;


public class GameView {
    public GameView() {

    }

    public void print() {
        System.out.print("숫자를 입력해주세요 :");
    }

    public void result(int ballCnt, int strikeCnt) {
        StringBuilder result = new StringBuilder();
        if (ballCnt == 0 && strikeCnt == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ballCnt != 0) result.append(Integer.toString(ballCnt) + "볼");
        if (result.length() != 0) result.append(" ");
        if (strikeCnt != 0) result.append(Integer.toString(strikeCnt) + "스트라이크");
        System.out.println(result);
        if (strikeCnt == 3) System.out.println("3개의 숫자를 모두 맞히셨습니다!");
    }

    public void renew() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
