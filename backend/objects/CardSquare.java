// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 9, 2015
// Description: This class models a card square in monopoly 
//              (ie. community chest or chance)

import java.lang.Math;
import java.lang.String;

public class CardSquare extends BoardLocation
{
    private static final int MAX = 200;          // max dollar amount player can win
    private static final int MIN = -200;         // minimum dollar amount player can lose

    public CardSquare()
    // POST: A default CardSquare object is created
    {
        super();                                 // call superclass constructor
    }

    public CardSquare(String name, int address)
    {
        super(name, address);
    }

    public String toString()
    // POST: FCTVAL == string representation of this CardSquare
    {   
        return super.toString();
    }

    public int drawChance()
    // POST: FCTVAL == random dollar amount to be taken or given to the player
    {
        return (int) ( (Math.random() * (MAX - MIN) + 1) + MIN);
    }

    public int drawCommunityChest()
    // POST: FCTVAL == random dollar amount to be taken or given to the player
    {
        return (int) ( (Math.random() * (MAX - MIN) + 1) + MIN);
    }

}
