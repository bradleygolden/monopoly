// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//

public abstract class Property 
{
    protected Player owner; // The owner of the property
    protected int price; // The purchase price of the property
    protected int baseRent; // The cost of rent on a given space without improvements 

    // POST: baseRent is set to 0, price is set to 0, owner is set to null
    //       Subclasses will initialize these values as needed
    public Property()
    {
        baseRent = 0;
        price = 0;
        owner = null;
    }

    // POST: FCTVAL = rent as an integer in dollar units for the current property
    public abstract int getRent();

}
