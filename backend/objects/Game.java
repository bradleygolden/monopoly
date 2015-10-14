// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//
import java.awt.Color;

public class Game
{
	private final Color SADDLE_BROWN = new Color(150, 75, 0);
    private final Color SKY_BLUE = new Color(135, 206, 235);
    private final Color DARK_ORCHARD = new Color(153,50,204);
    private final Color ORANGE = Color.ORANGE;
    private final Color RED = Color.RED;
    private final Color YELLOW = Color.YELLOW;
    private final Color GREEN = Color.GREEN;
    private final Color BLUE = Color.BLUE;

	private BoardLocation[] board;   // array of all board locations
	private Player[] players;        // array of player
	private int currentPlayerIndex;  // index into player array for current player
	private Dice dice;               // rollDie -> int

	public Game()
	{
		board = new BoardLocation[40];
		players = null;
		dice = new Dice();

		//South side of the board
        board[0] = new CornerSquare("Go", 0);
        currentPlayer = 0;
        // add all board locations
	}

	public void makeMove()
	{
		Player current = players[currentPlayerIndex];
		int roll = dice.rollDie();
		BoardLocation newLocation = board[(roll + current.getBoardLocation.getAddress()) % 40];
		current.setLocation(newLocation);
		String[] moves = current.getPossibleActions();

		// do actions

		// move to next player
		currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
	}

	public void addPlayer(int money, String token, BoardLocation location) 
	{
		Player p = new Player(money, token, location);
		if(players == null)
		{
			players = new Player[] {p};
			return;
		}
		
		Player[] newPlayer = new Player[player.length + 1]; // new array
        for(int i = 0; i < player.length; i++) // copy over old array
        {
            newPlayer[i] = player[i];
        }
        newPlayer[player.length] = p;
        player = newPlayer;
	}

    public static void main(String[] args)
    {

    }
}
