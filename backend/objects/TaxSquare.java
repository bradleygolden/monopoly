// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 9, 2015
// Description: This class models a tax square in monopoly 
//              (ie. income tax and luxury tax)

import java.lang.String;

public class TaxSquare extends BoardLocation
{
    private static final String[] POSSIBLE_ACTIONS =  {"Pay Tax"};  // Actions list 
    private static final int INCOMETAX = 200;    // amount player must pay when landing on
                                                 //     income tax
    private static final int LUXURYTAX = 75;     // amount player must pay when landing on
                                                 //     luxury tax
    public TaxSquare()
    // POST: A default TaxSquare object is created
    {
        super();                                 // call superclass constructor
    }

    public TaxSquare(String name, int address)
    {
        super(name, address);
    }

    public String toString()
    // POST: FCTVAL == string representation of this TaxSquare
    {   

        if(this.name.equals("Luxury Tax"))       // Player landed on Luxury Tax
            return super.toString() + " Luxury Tax: $" + LUXURYTAX;
        else                                     // Player landed on Income Tax
            return super.toString() + " Income Tax: $" + INCOMETAX;
    }

    public int getIncomeTax()
    // POST: FCTVAL == amount of money player must pay for landing on income tax
    {
        return INCOMETAX;
    }

    public int getLuxuryTax()
    // POST: FCTVAL == amount of money player must pay for landing on luxury tax
    {
        return LUXURYTAX;
    }

    public String[] getPossibleActions(Player player)
    // PRE:  player is initialized
    // POST: FCTVAL == string of possible player actions
    {
        String[] possibleActions;       // Gather strings of possible player actions
        
        possibleActions = new String[1];
        possibleActions[0] = POSSIBLE_ACTIONS[0];

        return possibleActions;
    }

}
