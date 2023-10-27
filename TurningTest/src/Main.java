import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Game> games = new HashMap<String, Game>();

    EventHandler.handleEvent(games, "+15555555555", "play");
    }
}



