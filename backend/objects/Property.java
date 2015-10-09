// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//

public abstract class Property 
{
    Player owner; // The owner of the property
    private int price; // The purchase price of the property
    private int baseRent; // The cost of rent on a given space without improvements 

    public Property()
    {
        baseRent = 0;
        price = 0;
    }

    public int getRent()
    {
        return baseRent;
    }

}
