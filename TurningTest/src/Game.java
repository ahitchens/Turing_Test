
import java.util.Random;

public class Game {
    //why string? Object with props? player class assigned with number and after add "player 1"
    private String judgePhoneNumber;
    private String playerPhoneNumber;

    private boolean playerAHuman;
    private String gameGoal;

    public Game(String judgePhoneNumber, String playerPhoneNumber) {
        this.judgePhoneNumber = judgePhoneNumber;
        this.playerPhoneNumber = playerPhoneNumber;
        Random random   = new Random();
        this.playerAHuman = random.nextInt(2) == 1  ? true :  false;

        String outcome1 = "Your job is to convince the judge that you are the human.";
        String outcome2 = "Your job is to convince the judge that you are the AI.";

        gameGoal = playerAHuman ? outcome1 : outcome2;

    }
    public String getJudgePhoneNumber() {
        return judgePhoneNumber;
    }
    public boolean getIsPlayerAHuman () {
        return playerAHuman;
    }
    public String getPlayerPhoneNumber() {
        return playerPhoneNumber;
    }

}
