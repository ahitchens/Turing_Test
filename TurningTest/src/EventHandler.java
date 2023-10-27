import java.util.Map;
import java.util.Random;
public class EventHandler {
    public static void handleEvent(Map<String, Game> games, String phoneNumber, String message) {

        //if number is known to us
        if(games.containsKey(phoneNumber)) {
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
        }else{
//phone number isn't known to us
            if (message.equals("play")){
                //create a new game
                //add a game to the games map
            Game game = new Game(phoneNumber, null);
            games.put(phoneNumber, game);
            //send a message to the phoneNumber saying "send a message to the judge to start the game"
        Twilio.sendSMS(phoneNumber, "send a message to the judge to start the game");
        } else{
            //send a message to the phoneNumber saying "send 'play' to start a game"
            Twilio.sendSMS(phoneNumber, "send 'play' to start a game");
        }
            }

        }



//    String gameGoal = getRandomOutcome();


 //   public static String getRandomOutcome() {
//        // Create a Random object
//        Random random = new Random();
//
//        // Generate a random number between 0 and 1
//        int randomNumber = random.nextInt(2); // Generates 0 or 1
//
//        // Define your two possible outcomes
//        String outcome1 = "Your job is to convince the judge that you are the human.";
//        String outcome2 = "Your job is to convince the judge that you are the AI.";
//
//
//        return (randomNumber == 0) ? outcome1 : outcome2;
//    }
//assign playerPhoneNumber to player1 or player2 randomly
//send a message to the playerPhoneNumber saying "you are player1" or "you are player2"
    //assign the opposite to chatbotPhoneNumber
    //send a message to the chatbotPhoneNumber saying "you are player1" or "you are player2"



    private static void handleGameAction(Game game, String message) {
        // Implement your game logic here
        //assign playerPhoneNumber to player1 or player2 randomly
        //send a message to the playerPhoneNumber saying "you are player1" or "you are player2"
        //send a message to OpenAI saying they are the opposite player number
        //send a message to the judgePhoneNumber saying "player1 is player1" or "player2 is player2"

    }
}

