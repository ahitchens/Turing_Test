import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class EventHandler {
    static Queue<String> playerQueue = new LinkedList<>();
    static Queue<String> judgeQueue = new LinkedList<>();

    public static void handleEvent(Map<String, Game> games, String phoneNumber, String message) {

        //if number is known to us
        if (games.containsKey(phoneNumber)) {

            Game game = games.get(phoneNumber);
            String judgePhoneNumber = game.getJudgePhoneNumber();
            String playerPhoneNumber = game.getPlayerPhoneNumber();

            if (phoneNumber.equals(judgePhoneNumber)) {
                //judge is sending a message
                System.out.println("Judge: " + message);
            } else {
                //player is sending a message
                System.out.println("Player: " + message);
            }
        } else {
//phone number isn't known to us
            switch (message) {
                case "play" -> {
                    //create a new game
                    //add a game to the games map
                    Twilio.sendSMS(phoneNumber, "decide which role you want to be: Player or Judge");

                    //send a message to the phoneNumber saying "send a message to the judge to start the game"
                    Twilio.sendSMS(phoneNumber, "send a message to the judge to start the game");
                }
                case "Player" -> {
                    if (!judgeQueue.isEmpty()) {
                        Game game = new Game(judgeQueue.remove(), phoneNumber);
                        Twilio.sendSMS(game.getJudgePhoneNumber(), "Match found, ask your question now");
                    } else {
                        //add the player to the playerQueue
                        judgeQueue.add(phoneNumber);
                        //send a message to the phoneNumber saying "you are in the queue"
                        Twilio.sendSMS(phoneNumber, "you are in the queue now... waiting for a judge");
                    }
                }
                case "Judge" -> {
                    if (!playerQueue.isEmpty()) {
                        Game game = new Game(phoneNumber, playerQueue.remove());
                        Twilio.sendSMS(game.getJudgePhoneNumber(), "Match found, ask your question now");

                    } else {
                        //add the judge to the judgeQueue
                        playerQueue.add(phoneNumber);
                        //send a message to the phoneNumber saying "you are in the queue"
                        Twilio.sendSMS(phoneNumber, "you are in the queue... waiting for a player");
                    }
                }
                default ->
                    //send a message to the phoneNumber saying "send 'play' to start a game"
                        Twilio.sendSMS(phoneNumber, "send 'play' to start a game");
            }
        }


    }

}

