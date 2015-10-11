// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//
import java.awt.Color;

public class TestDriver
{
    public static void main()
    {
        BoardLocation[] board = new BoardLocation[40];    

        // board colors
        Color SADDLE_BROWN = new Color(150, 75, 0);
        Color SKY_BLUE = new Color(135, 206, 235);
        Color DARK_ORCHARD = new Color(153,50,204);
        Color ORANGE = Color.ORANGE;
        Color RED = Color.RED;
        Color YELLOW = Color.YELLOW;
        Color GREEN = Color.GREEN;
        Color BLUE = Color.BLUE;

        // All board locations are initialized in the order in which they are displayed on the Monopoly Board
        // starting from go.
        
        // CornerSquare(name, address)
        // Lot(name, address, color, price, base rent)
        // CardSquare(name, address)
        // TaxSquare(name, address) 
        // Railroad(name, address)
        // Utility(name, address)

        //South side of the board
        board[0] = new BoardLocation("Go", 0);
        board[1] = new Lot("Mediterranean Avenue", 1, SADDLE_BROWN, 60, 0);
        board[2] = new CardSquare("Community Chest", 2);
        board[3] = new Lot("Baltic Avenue", 3, SADDLE_BROWN, 60, 0);
        board[4] = new TaxSquare("Income Tax", 4);
        board[5] = new Railroad("Reading Railroad", 5);
        board[6] = new Lot("Oriental Avenue", 6, SKY_BLUE, 100, 0);
        board[7] = new CardSquare("Chance", 7);
        board[8] = new Lot("Vermont Avenue", 8, SKY_BLUE, 100 ,0);
        board[9] = new Lot("Connecticut Avenue", 9, SKY_BLUE, 120, 0);

        board[10] = new CornerSquare("Jail", 10);

        // West side of the board
        board[11] = new Lot("St. Charles Place", 11, DARK_ORCHARD, 140, 0);
        board[12] = new Utility("Electric Company", 12);
        board[13] = new Lot("States Avenue", 13, DARK_ORCHARD, 140, 0);
        board[14] = new Lot("Virginia Avenue", 14, DARK_ORCHARD, 160, 0);
        board[15] = new Railroad("Pennsylvania Railroad", 15);
        board[16] = new Lot("St. James Place", 16, ORANGE, 180, 0);
        board[17] = new CardSquare("Community Chest", 17);
        board[18] = new Lot("Tennesse Avenue", 18, ORANGE, 180, 0);
        board[19] = new Lot("New York Avenue", 19, ORANGE, 200, 0);

        board[20] = new CornerSquare("Free Parking", 20);

        // North side of the board
        board[21] = new Lot("Kentucky Avenue", 21, RED, 220, 0);
        board[22] = new CardSquare("Chance", 22);
        board[23] = new Lot("Indiana Avenue", 23, RED, 220, 0);
        board[24] = new Lot("Illiois Avenue", 24, RED, 240, 0);
        board[25] = new Railroad("B. & O. Railroad", 25);
        board[26] = new Lot("Atlantic Avenue", 26, YELLOW, 260, 0);
        board[27] = new Lot("Ventnor Avenue", 27, YELLOW, 260, 0);
        board[28] = new Utility("Water Works", 28);
        board[29] = new Lot("Marvin Gardens", 29, YELLOW, 280, 0);

        board [30] = new CornerSquare("Go To Jail", 30);
        
        // East side of the board
        board[31] = new Lot("Pacific Avenue", 31, GREEN, 300, 0);
        board[32] = new Lot("North Carolina Avenue", 32, GREEN, 300, 0);
        board[33] = new CardSquare("Community Chest", 33);
        board[34] = new Lot("Pennsylvania Avenue", 34, GREEN, 320, 0);
        board[35] = new Railroad("Short Line", 35);
        board[36] = new CardSquare("Chance", 36);
        board[37] = new Lot("Park Place", 37, BLUE, 350, 0);
        board[38] = new TaxSquare("Luxury Tax", 38);
        board[39] = new Lot("Boardwalk", 39, BLUE, 400, 0);
    }

    // Iterate through each board element and print it out
    for (boardElem : board)
    {
        System.out.println(board[i].toString());
    }
}
