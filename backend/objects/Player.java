// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description: 
//              

public class Player 
{
    private int money;              // amount of money a player has
    private BoardLocation location; // track the location of a player on the board
    private String token;           // piece that represents player
    private Property[] properties;  // list of properties owned by the player

    //POST:  a new player will be created with $0, starting at Go, no properties
    public Player() 
    {
        money = 0;
        //location = BoardLocation.GO;

    }
}
