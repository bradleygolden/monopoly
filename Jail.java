// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description: This class models a jail space in monopoly.
//              If a player lands in jail and cannot afford to
//              pay the rent, they are stuck in jail forever.

public class Jail extends CornerSquare 
{
    private static final int JAILRENT = 150;   // Price to get out of Jail

    private static final String[] POSSIBLE_ACTIONS =  {"Free Parking", 
                                                          "Pay Rent"}; // Actions List
    public Jail()
    // POST: Jail object created
    {
        super();                    // call super constructor
    }

    public Jail(String name, int address)
    // PRE:  name and address are initialized
    // POST: Jail object created with name set to name and address 
    //       set to address
    {
        super(name, address);
    }

    public int getRent()
    // POST: FCTVAL == JAILRENT or the amount of money the player
    //       must pay to leave the jail location
    {
        return JAILRENT;
    }

    public String[] getPossibleActions(Player player)
    // POST: FCTVAL == string array of possible player actions
    {
    
        String[] possibleActions;       // Gather strings of possible player actions
    
        possibleActions = new String[2];
        possibleActions[0] = POSSIBLE_ACTIONS[0];
        possibleActions[1] = POSSIBLE_ACTIONS[1];
        
        return possibleActions;
    }

    @Override
    public String toString() 
    // POST: FCTVAL == string representation of the jail square
    {
        return super.toString() + "Get out of Jail Cost: " + JAILRENT;
    }

}
