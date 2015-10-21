// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//
import java.util.Random;
import java.awt.Color;

public class Game
{
	public static final String[] TOKENS = {"Scottish Terrier", "Battleship", "Automobile", "Top Hat",
        "Thimble", "Boot", "Wheelbarrow", "Cat"};
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
	private boolean moveMade;        // current player has made their move

	public Game(String setting)
	// PRE: setting is either "normal" or "demo"
	//POST: a new instance of the game will be made in either demo mode
	//      or normal meaning three players, at different parts of the board
	{
		this();
		if(setting.equals("demo"))
		{
			addPlayer(100, Game.TOKENS[0], board[12]);
    		addPlayer(1000, Game.TOKENS[1], board[4]);

    		addPlayer(149, Game.TOKENS[1], board[10]);
    	
    		players[0].addProperty((Property) board[1]);
    		((Lot) board[1]).improve();
    		((Lot) board[1]).improve();
    		((Lot) board[1]).improve();
    		players[0].addProperty((Property) board[3]);
    		((Lot) board[3]).improve();
    		players[0].addProperty((Property) board[5]);
    		players[0].addProperty((Property) board[6]);
    		((Lot) board[6]).improve();
    		((Lot) board[6]).improve();
    		((Lot) board[6]).improve();
    		players[0].addProperty((Property) board[8]);
    		((Lot) board[8]).improve();
    		players[0].addProperty((Property) board[9]);
    		((Lot) board[9]).improve();

    		players[1].addProperty((Property) board[11]);
    		((Lot) board[11]).improve();
    		((Lot) board[11]).improve();
    		((Lot) board[11]).improve();
    		players[1].addProperty((Property) board[12]);
    		players[1].addProperty((Property) board[13]);
    		((Lot) board[13]).improve();
    		players[1].addProperty((Property) board[14]);
    		((Lot) board[14]).improve();
    		players[1].addProperty((Property) board[15]);
    		players[1].addProperty((Property) board[16]);
    		((Lot) board[16]).improve();
    		((Lot) board[16]).improve();
    		((Lot) board[16]).improve();
		}
		else if(setting.equals("normal"))
		{
			// by default 8 players are added
			addPlayer(1000, Game.TOKENS[0], board[0]);
    		addPlayer(1000, Game.TOKENS[1], board[0]);
    		addPlayer(1000, Game.TOKENS[2], board[0]);	
    		addPlayer(1000, Game.TOKENS[3], board[0]);
    		addPlayer(1000, Game.TOKENS[4], board[0]);
    		addPlayer(1000, Game.TOKENS[5], board[0]);
    		addPlayer(1000, Game.TOKENS[6], board[0]);
    		addPlayer(1000, Game.TOKENS[7], board[0]);
		}
	}


	public Game()
	//POST: a new instance of the game will be made
	{
		board = new BoardLocation[40];
		players = null;
		dice = new Dice();
		currentPlayerIndex = 0;
		diceState = new int[] {0, 0};
		moveMade = false;

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

        board[10] = new Jail("Jail", 10);

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
	// PRE: the dice will be rolled and the current player
	//      will be moved to the new space on the board
	{
		Player current = players[currentPlayerIndex];
		int[] roll = rollDice();
		int rollNumber = roll[0] + roll[1];
		BoardLocation newLocation = board[(rollNumber + current.getBoardLocation().getAddress()) % 40];
		current.moveTo(newLocation);
	}

	
	public boolean performAction(String action)
	// PRE: action is a valid action from getPossibleActions
	//POST: the action will be performed and FUNCVAL == true
	{
		Player currentPlayer = players[currentPlayerIndex];
		BoardLocation currentLocation = players[currentPlayerIndex].getBoardLocation();

		if(currentLocation instanceof Lot ||
		   currentLocation instanceof Railroad ||
		   currentLocation instanceof Utility)
		{
			if(action.equals("Purchase"))
			{
				currentPlayer.removeMoney(((Property) currentLocation).getPrice());
				currentPlayer.addProperty((Property) currentLocation);
			}
			if(action.equals("Pay Rent"))
			{
				if(currentLocation instanceof Utility)
				{
					if(currentPlayer.getMoney() < ((Property) currentLocation).getRent(currentPlayer, diceState[0] + diceState[1])) 
					{
						return false; // cannot pay
					}
					currentPlayer.removeMoney(((Property) currentLocation).getRent(currentPlayer, diceState[0] + diceState[1]));
					((Property) currentLocation).getOwner().addMoney(((Property) currentLocation).getRent(currentPlayer, diceState[0] + diceState[1]));
				}
				else
				{
					if(currentPlayer.getMoney() < ((Property) currentLocation).getRent(currentPlayer)) 
					{
						return false; // cannot pay
					}
					currentPlayer.removeMoney(((Property) currentLocation).getRent(currentPlayer));
					((Property) currentLocation).getOwner().addMoney(((Property) currentLocation).getRent(currentPlayer));
				}
			}
		}
		if(currentLocation instanceof CornerSquare)
		{
			if(action.equals("Collect Money"))
			{
				currentPlayer.addMoney(((CornerSquare) currentLocation).collectMoney());
			}
		}
		if(currentLocation instanceof CardSquare)
		{
			if(action.equals("Collect Money"))
			{
				int money = ((CardSquare) currentLocation).drawChance();
				if(money < 0)
				{
					currentPlayer.removeMoney(money * -1); // Tax square: getTax
				}
				else 
				{
					currentPlayer.addMoney(money);
				}
			}
		}
		if(currentLocation instanceof TaxSquare)
		{
			if(action.equals("Pay Tax"))
			{
				int money = ((TaxSquare) currentLocation).getTax();
				if(currentPlayer.getMoney() < money)
				{
					return false; // can't pay
				}
				else
				{
					currentPlayer.removeMoney(money); // Tax square: getTax
				}
			}
		}
		if(currentLocation instanceof Jail)
		{
			if(action.equals("Pay Rent"))
			{
				int cost = ((Jail) currentLocation).getRent();
				if(currentPlayer.getMoney() >= cost)
				{
					currentPlayer.removeMoney(cost);
					BoardLocation newLocation = board[(currentPlayer.getBoardLocation().getAddress() + 1) % 40];
					currentPlayer.moveTo(newLocation);
				}
				else 
				{
					return false; // can't pay
				}
			}
		}
		moveMade = true;
		return true;
	}

	public void startGame()
	//POST: the game will start by randomizing the order of the players
	{
		Random r = new Random(System.currentTimeMillis());
		for(int i = 0; i < players.length * 2; i++)
		{
			int p1 = (int) (r.nextFloat() * players.length);
			int p2 = (int) (r.nextFloat() * players.length);
			Player tmp = players[p1];
			players[p1] = players[p2];
			players[p2] = tmp;
		}
	}

	public Color getColor()
	//POST: the color of the current space will be returned
	//      or white will be returned if there is no current color
	{
		if(players[currentPlayerIndex].getBoardLocation() instanceof Lot)
		{
			return ((Lot) players[currentPlayerIndex].getBoardLocation()).getColor();
		}
		return Color.WHITE;
	}

	public boolean nextTurn()
	//POST: the current player will advance to the next player unless
	//      the current player got doubles, then they get to go again
	{
		if(moveMade)
		{
			// move to next player if current player does not have doubles
			if(diceState[0] != diceState[1])
			{
				currentPlayerIndex = (currentPlayerIndex + 1) % players.length;	
			}
			
			moveMade = false;
			return true;
		}
		return false;
	}

	public String leaveGame()
	//POST: removes current player from game
	{
		if(players.length == 2) 
		{
			return "You cannot play Monopoly with less than two players... Duhh.";
		}
		String name = players[currentPlayerIndex].getToken();
		int nextPlayer = (currentPlayerIndex + 1) % players.length;
		Player[] newPlayers = new Player[players.length - 1];
		players[currentPlayerIndex] = null;
		for(int i = 0, j = 0; i < players.length; i++)
		{
			if(players[i] != null)
			{
				newPlayers[j] = players[i];
				j++;
			}
		}
		players = newPlayers;
		currentPlayerIndex = (nextPlayer - 1) % players.length; // fix loop around in case out of bounds
		return name + " has left the game";
	}

	public Property[] getProperties() 
	//POST: returns the array of 28 properties on the board
	{
		Property[] properties = new Property[28];
		int[] indexArray = new int[] {1, 3, 5, 6, 8, 9, 11, 12, 13, 14, 15, 16, 
			18, 19, 21, 23, 24, 25, 26, 27, 28, 29, 31, 32, 34, 35, 37, 39};

		for(int i = 0; i < 28; i++) 
		{
			properties[i] = (Property) board[indexArray[i]];
		}
		return properties;
	}

	public String[] getPossibleActions()
	//POST: returns the array of possible actions for the current player
	{
		return players[currentPlayerIndex].getBoardLocation().getPossibleActions(players[currentPlayerIndex]);
	}

	public int[] rollDice() 
	//POST: the result of the dice roll will be returned and stored 
	//      so you can get it from getDiceValues() as well
	{
		diceState[0] = dice.rollDie();
		diceState[1] = dice.rollDie();

		return diceState;
	}

	public int[] getDiceValues()
	//POST: returns dice values
	{
		return diceState;
	}

	public Player[] getPlayers()
	//POST: returns array of players
	{
		return players;
	}

	public Player getPlayer()
	//POST: returns current player
	{
		return players[currentPlayerIndex];
	}

	public BoardLocation getLocation()
	//POST: returns location of current player
	{
		return players[currentPlayerIndex].getBoardLocation();
	}

    public String getLocationName()
    //POST: FCTVAL == name of location the current player is at
    {
        return players[currentPlayerIndex].getBoardLocation().getName();
    }

	public BoardLocation getGo()
	//POST: returns the array location of the Go space
	{
		return board[0];
	}

	public BoardLocation[] getBoard()
	//POST: returns the board array
	{
		return board;
	}

	public boolean sellImprovement(Property p)
	{
		if(p instanceof Lot)
		{
			int cost = ((Lot) p).getImprovementCost() / 2;
			if(((Lot) p).sellImprovement())
			{
				players[currentPlayerIndex].addMoney(cost);
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public boolean improveProperty(Property p)
	//PRE:  property is a vaild property
	//POST: the property will be improved and the cost will be removed
	//      from the current player
	{
		if(p instanceof Lot)
		{
			int cost = ((Lot) p).getImprovementCost();
			if(players[currentPlayerIndex].getMoney() >= cost) 
			{
				if(((Lot) p).improve()) 
				{
					players[currentPlayerIndex].removeMoney(cost);
					return true;
				}
				else 
				{
					return false;
				}
			}
			else 
			{
				return false;
			}
		}
		else 
		{
			return false;
		}
	}

	public void addPlayer(int money, String token, BoardLocation location) 
	//PRE:  money >= 0, token is a valid token string, and location is a valid location
	//POST: the player will be initialized and added to the list of players for the game
	{
		Player p = new Player(money, token, location);
		if(players == null)
		{
			players = new Player[] {p};
			return;
		}
		
		Player[] newPlayer = new Player[players.length + 1]; // new array
        for(int i = 0; i < players.length; i++) // copy over old array
        {
            newPlayer[i] = players[i];
        }
        newPlayer[players.length] = p;
        players = newPlayer;
	}

	public String spacesToString()
	//POST: returns the board as a string
	{
		String s = "";
		for(BoardLocation b : board)
		{
			s += b.toString();
		}
		return s;
	}

	public String playersToString()
	//POST: returns the player list as a string
	{
		String s = "";
		for(Player player : players)
        {
            s += player.toString();
        }
        return s;
	}

	@Override
	public String toString()
	//POST: returns toStrings of the players
	{
		String s = "";
		for(Player p : players)
		{
			Property[] properties = p.getProperties();
			if(properties == null)
			{
				s += p.simpleToString() + " Owns no properties\n";
			}
			else {
				s += p.simpleToString() + " Owns properties:\n";
				for(Property prop : properties)
				{
					s += "   " + prop.simpleToString() + "\n";
				}
			}
			s += "\n";
		}
		return s;
	}

	public static void demo()
	{
		Game g = new Game("demo");
    	g.startGame();

    	g.spacesToString();
    	System.out.println("----------------------------");
        System.out.println("        Player Tests        ");
        System.out.println("----------------------------");
    	g.playersToString();

    	g.makeMove();
    	String[] arr = g.getPossibleActions();
    	g.performAction(arr[0]);
    	g.nextTurn();

    	// next player
    	g.makeMove();
    	arr = g.getPossibleActions();
    	g.performAction(arr[0]);
    	g.nextTurn();

    	// next player
    	g.makeMove();
    	arr = g.getPossibleActions();
    	g.performAction(arr[0]);
    	g.nextTurn();


    	System.out.println(g.toString());

	}

    public static void main(String[] args)
    {
    	
    	demo();

    }
}
