public class GameConsole
{
    public static void main(String[] args)
    {
        // load game
        Game game = new Game("demo");
        game.startGame();

        // load properties
        Property[] properties = new Property[28];
        properties = game.getProperties();
        for (Property elem : properties)
        {
            //System.out.println(elem.toString());
        }

        // load players
        Player[] players = new Player[8];
        players = game.getPlayers();
        for (Player elem : players)
        {
            //System.out.println(elem.toString());
        }

        //Player player = game.getPlayer();
        //System.out.println(player.toString());

        String[] actions = game.getPossibleActions();
        for (String action : actions)
        {
            //System.out.println(action);
        }

        // test dice roll
        int[] diceValues = new int[2];
        for (int i = 0; i < 20; i++)
        {
            //diceValues = game.rollDice();
            //System.out.println(diceValues[0] + " " + diceValues[1]);
        }

        //System.out.println(game.getPlayer().toString());
        //game.makeMove();
        //game.nextTurn();
        //System.out.println(game.getPlayer().toString());
        //game.performAction("Purchase");
        //System.out.println(game.getPlayer().toString());

        System.out.println(game.getLocationName().toString());
        System.out.println(game.getColor());
    }
}
