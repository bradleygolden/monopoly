// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//

public class CornerSquare 
{
    private int goAmount; // the pass go amount

    public CornerSquare(String name, int address, int goAmount)
    // PRE: name and address are valid, and goAmount >= 0
    //POST: CornerSquare will be made with the specified attributes
    {
        super(name, address);
        this.goAmount = goAmount;
    }

    // POST: sets goamount to goamount
    public CornerSquare(int goAmount)
    {
        super();
        this.name = name;
        this.address = address;
    }

    public int collectMoney()
    {
        if(isGo())
        {
            return goAmount;
        }
        return 0;
    }

    public boolean isGo()
    {
        return super.name.equals("Go");
    }

    public String[] getPossibleActions()
    {
        if(this.isGo()) // TODO
        {
            return new String[] {"Collect Money"};
        }
        return new String[] {"Free Parking"};
    }

    // POST: FCTVAL = go amount
    @Override
    public String toString() 
    {
        return "Pass go amount: " + goAmount;
    }

}
