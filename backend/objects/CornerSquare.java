// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description: This class models a corner square in monopoly. (ie. Free Parking, Go To Jail, etc..)

public class CornerSquare extends BoardLocation 
{
    private int goAmount;           // the pass go amount

    public CornerSquare()
    // POST: CornerSquare object created where goAmount is set to zero
    {
        super();                    // call super constructor
        this.goAmount = 0;
    }

    public CornerSquare(String name, int address, int goAmount)
    // PRE:  name and address are valid, and goAmount >= 0
    // POST: CornerSquare will be made with the specified attributes
    {
        super(name, address);
        this.goAmount = goAmount;
    }

    public CornerSquare(int goAmount)
    // POST: CornerSquare object created where goAmount is set to goAmount
    {
        this();
        this.goAmount = goAmount;
    }

    public int collectMoney()
    // POST: FCTVAL == goAmount (ie. amount of money a player recieves for passing Go)
    {
        if(isGo())              // Current board location is Go
        {
            return goAmount;
        }

        return 0;               // Otherwise return zero
    }

    public boolean isGo()
    // POST: FCTVAL == true if current location is "Go", false otherwise
    {
        return super.name.equals("Go");
    }

    public String[] getPossibleActions()
    // POST: FCTVAL == string array of possible player actions
    {
        if(this.isGo())        // Location is Go
        {
            return new String[] {"Collect Money"};
        }

        return new String[] {"Free Parking"};
    }

    @Override
    public String toString() 
    // POST: FCTVAL == string representation of a corner square
    {
        return "Pass go amount: " + goAmount;
    }

}
