public class Game {
    private String judgePhoneNumber;
    private String playerPhoneNumber;

    public Game(String judgePhoneNumber, String playerPhoneNumber) {
        this.judgePhoneNumber = judgePhoneNumber;
        this.playerPhoneNumber = playerPhoneNumber;
    }
    public String getJudgePhoneNumber() {
        return judgePhoneNumber;
    }
    public String getPlayerPhoneNumber() {
        return playerPhoneNumber;
    }

}
