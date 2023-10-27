/* import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EventHandler {

    private static Map<String, Game> games = new HashMap<>();

    public static void handleEvent(String phoneNumber, String message) {
        if (games.containsKey(phoneNumber)) {
            Game game = games.get(phoneNumber);
            if (phoneNumber.equals(game.getJudgePhoneNumber())) {
                // judge is sending a message
                System.out.println("Judge: " + message);
            } else {
                // player is sending a message
                System.out.println("Player: " + message);
            }
        } else {
            if ("play".equalsIgnoreCase(message)) {
                Game game = new Game(phoneNumber, "OpenAI_PhoneNumber"); // Assume AI has a fixed phone number
                games.put(phoneNumber, game);
                Twilio.sendSMS(phoneNumber, "send a message to the judge to start the game");
            } else {
                Twilio.sendSMS(phoneNumber, "send 'play' to start a game");
            }
        }

        String gameGoal = getRandomOutcome();
        handleGameAction(games.get(phoneNumber), gameGoal);
    }

    public static String getRandomOutcome() {
        Random random = new Random();
        return (random.nextInt(2) == 0) ?
                "Your job is to convince the judge that you are the human." :
                "Your job is to convince the judge that you are the AI.";
    }

    public static void handleGameAction(Game game, String gameGoal) {
        Random random = new Random();

        if(random.nextInt(2) == 0) {
            Twilio.sendSMS(game.getPlayerPhoneNumber(), gameGoal);
            Twilio.sendSMS(game.getChatbotPhoneNumber(),
                    gameGoal.equals("Your job is to convince the judge that you are the human.") ?
                            "Your job is to convince the judge that you are the AI." :
                            "Your job is to convince the judge that you are the human."
            );
        } else {
            Twilio.sendSMS(game.getChatbotPhoneNumber(), gameGoal);
            Twilio.sendSMS(game.getPlayerPhoneNumber(),
                    gameGoal.equals("Your job is to convince the judge that you are the human.") ?
                            "Your job is to convince the judge that you are the AI." :
                            "Your job is to convince the judge that you are the human."
            );
        }

        // Inform the judge about player's role
        Twilio.sendSMS(game.getJudgePhoneNumber(),
                gameGoal.equals("Your job is to convince the judge that you are the human.") ?
                        "player1 is the human." :
                        "player1 is the AI."
        );
    }

    public static void main(String[] args) {
        // Test the game logic
        handleEvent("testPhoneNumber", "play");
    }
}

class Game {
    private String playerPhoneNumber;
    private String chatbotPhoneNumber;
    private final String judgePhoneNumber = "Judge_PhoneNumber"; // Assume judge has a fixed phone number

    public Game(String playerPhoneNumber, String chatbotPhoneNumber) {
        this.playerPhoneNumber = playerPhoneNumber;
        this.chatbotPhoneNumber = chatbotPhoneNumber;
    }

    public String getPlayerPhoneNumber() {
        return playerPhoneNumber;
    }

    public String getChatbotPhoneNumber() {
        return chatbotPhoneNumber;
    }

    public String getJudgePhoneNumber() {
        return judgePhoneNumber;
    }
}

class Twilio {
    public static void sendSMS(String phoneNumber, String message) {
        // Here, you'd have the logic to send an SMS using the Twilio API
        // For the sake of this example, we'll just print the message
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}

 */