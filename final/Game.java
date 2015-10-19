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
	private int[] diceState;         // values of the two current dice rolled

	public Game()
	{
		board = new BoardLocation[40];
		players = null;
		dice = new Dice();
		currentPlayer = 0;
		diceState = new int[] {0, 0};

		// All board locations are initialized in the order in which they are displayed on the Monopoly Board
        // starting from go.

        // CornerSquare(name, address)
        // Lot(name, address, color, price, base rent, improvement cost)
        // CardSquare(name, address)
        // TaxSquare(name, address) 
        // Railroad(name, address)
        // Utility(name, address)
        //

        //South side of the board
        board[0] = new CornerSquare("Go", 0);
        board[1] = new Lot("Mediterranean Avenue", 1, SADDLE_BROWN, 60, 2, 50, 10, 30, 90, 160, 230);
        board[2] = new CardSquare("Community Chest", 2);
        board[3] = new Lot("Baltic Avenue", 3, SADDLE_BROWN, 60, 4, 50, 20, 60, 180, 320, 450);
        board[4] = new TaxSquare("Income Tax", 4);
        board[5] = new Railroad("Reading Railroad", 5);
        board[6] = new Lot("Oriental Avenue", 6, SKY_BLUE, 100, 6, 50, 30, 90, 270, 400, 550);
        board[7] = new CardSquare("Chance", 7);
        board[8] = new Lot("Vermont Avenue", 8, SKY_BLUE, 100 , 6, 50, 30, 90, 270, 400, 550);
        board[9] = new Lot("Connecticut Avenue", 9, SKY_BLUE, 120, 8, 50, 40, 100, 300, 450, 600);

        board[10] = new CornerSquare("Jail", 10);

        // West side of the board
        board[11] = new Lot("St. Charles Place", 11, DARK_ORCHARD, 140, 10, 100, 50, 150, 450, 625, 
                750);
        board[12] = new Utility("Electric Company", 12);
        board[13] = new Lot("States Avenue", 13, DARK_ORCHARD, 140, 10, 100, 50, 150, 450, 625, 750);
        board[14] = new Lot("Virginia Avenue", 14, DARK_ORCHARD, 160, 12, 100, 60, 180, 500, 700, 
                900);
        board[15] = new Railroad("Pennsylvania Railroad", 15);
        board[16] = new Lot("St. James Place", 16, ORANGE, 180, 14, 100, 70, 200, 550, 750, 950);
        board[17] = new CardSquare("Community Chest", 17);
        board[18] = new Lot("Tennesse Avenue", 18, ORANGE, 180, 14, 100, 70, 200, 550, 750, 950);
        board[19] = new Lot("New York Avenue", 19, ORANGE, 200, 16, 100, 80, 220, 600, 800, 1000);

        board[20] = new CornerSquare("Free Parking", 20);

        // North side of the board
        board[21] = new Lot("Kentucky Avenue", 21, RED, 220, 18, 150, 90, 250, 700, 875, 1050);
        board[22] = new CardSquare("Chance", 22);
        board[23] = new Lot("Indiana Avenue", 23, RED, 220, 18, 150, 90, 250, 700, 875, 1050);
        board[24] = new Lot("Illiois Avenue", 24, RED, 240, 20, 150, 100, 300, 750, 925, 1100);
        board[25] = new Railroad("B. & O. Railroad", 25);
        board[26] = new Lot("Atlantic Avenue", 26, YELLOW, 260, 22, 150, 110, 330, 800, 975, 1150);
        board[27] = new Lot("Ventnor Avenue", 27, YELLOW, 260, 22, 150, 110, 330, 800, 975, 1150);
        board[28] = new Utility("Water Works", 28);
        board[29] = new Lot("Marvin Gardens", 29, YELLOW, 280, 24, 150, 120, 360, 850, 1025, 1200);

        board [30] = new CornerSquare("Go To Jail", 30);

        // East side of the board
        board[31] = new Lot("Pacific Avenue", 31, GREEN, 300, 26, 200, 130, 390, 850, 1025, 1200);
        board[32] = new Lot("North Carolina Avenue", 32, GREEN, 300, 26, 200, 130, 390, 900, 1100,
                1275);
        board[33] = new CardSquare("Community Chest", 33);
        board[34] = new Lot("Pennsylvania Avenue", 34, GREEN, 320, 28, 200, 150, 450, 1000, 1200,
                1400);
        board[35] = new Railroad("Short Line", 35);
        board[36] = new CardSquare("Chance", 36);
        board[37] = new Lot("Park Place", 37, BLUE, 350, 35, 200, 150, 450, 1000, 1200, 1400);
        board[38] = new TaxSquare("Luxury Tax", 38);
        board[39] = new Lot("Boardwalk", 39, BLUE, 400, 50, 200, 200, 600, 1400, 1700, 2000);
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

	/*public boolean performAction(String action)
	{
		Player currentPlayer = palyers[currentPlayerIndex];
		BoardLocation currentLocation = players[currentPlayerIndex].getBoardLocation();
		if(currentLocation instanceof Lot)
		{
			if(action.equals("Purchase Improvement"))
			{
				currentPlayer.removeMoney(currentLocation.getImprovementCost());
			}
			if(action.equals("Purchase"))
			{
				currentPlayer.removeMoney(currentLocation.getCost());
				currentPlayer.addProperty((Property) currentLocation);
				((Property) currentLocation).setOwner(currentPlayer);
			}
			if(action.equals("Pay Rent"))
			{
				currentPlayer.removeMoney(currentLocation.getRent());
				currentLocation.getOwner().addMoney(currentLocation.getRent());
			}
			if(action.equals("Pay Rent"))
			{
				currentPlayer.removeMoney(currentLocation.getRent());
				currentLocation.getOwner().addMoney(currentLocation.getRent());
			}
		}
	}*/

	public boolean netTurn()
	{
			
	}

	public Property[] getProperties() 
	{
		Property[] properties = new Property[28];
		int[] indexArray = new int[] {1, 3, 5, 6, 8, 9, 11, 12, 13, 14, 15, 16, 
			18, 19, 21, 23, 24, 25, 26, 27, 28, 29, 31, 32, 34, 35, 37, 39};

		for(int i = 0; i < 28; i++) 
		{
			properties[i] = board[indexArray[i]];
		}
		return properties;
	}

	public String getPossibleActions()
	{
		return players[currentPlayerIndex].getBoardLocation().getPossibleActions();
	}

	public int[] rollDice() 
	{
		diceState[0] = dice.rollDie();
		diceState[1] = dice.rollDie();

		return diceState;
	}

	public int[] getDiceValues()
	{
		return diceState;
	}

	public Player[] getPlayers()
	{
		return players;
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