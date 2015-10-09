// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//

public class Utility extends Property
{
    private int numUtilitiesOwned; // The number of utilities owned by the current owner
    private Property[] ownerProperties; // An array of properties owned by the owner

    public Utility()
    {
        super();
        super.price = 0; // TODO - the price is difference for each utility! 
        super.baseRent = 1; // The baseRent without the dice multplier

        ownerProperties = super.owner.getProperties(); // Get an array of properties this owner owns
        numUtilitiesOwned = this.getNumUtilitiesOwned(); // Get number of railroads owned by this owner
    }

    // POST: FCTVAL == Number of utlities owned by the current owner
    //                 Integer value in dollars where count >= 0 and count <= 2
    private int getNumUtilitiesOwned()
    {
        int count = 0;

        for (Property aProperty : ownerProperties) // loop through all properties owned by owner
        {
            if (aProperty.isInstance(Utility)) // check if a property is a utility
            {
                count++; // increment count if owner owns another utility
            }
        }

        return count;
    }

    public int getRent()
    {
    }

    public int sell()
    {
        /*-------------------------------------

          COPIED FROM http://www.hasbro.com/common/instruct/monins.pdf

          Unimproved properties, railroads and
          utilities (but not buildings) may be sold to any player as a private
          transaction for any amount the owner can get; however, no property
          can be sold to another player if buildings are standing on any
          properties of that color-group. Any buildings so located must be sold
          back to the Bank before the owner can sell any property of that color-group.
          Houses and hotels may be sold back to the Bank at any time for
          one-half the price paid for them.
          All houses on one color-group must be sold one by one, evenly, in
          reverse of the manner in which they were erected.
          All hotels on one color-group may be sold at once, or they may be
          sold one house at a time (one hotel equals five houses), evenly, in
          reverse of the manner in which they were erected.

          -------------------------------------*/
    }

    public int buy(Player buyer)
    {
        super.owner = buyer;
        super.owner.withdraw(super.baseRent);
    }
}
