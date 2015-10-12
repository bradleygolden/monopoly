// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//

public class Utility extends Property
{
    private int numUtilitiesOwned; // The number of utilities owned by the current owner
    private Property[] ownerProperties; // An array of properties owned by the owner

    //POST: Utility object is created with price set to 150, baseRent set to 1, ownerProperties
    //      initialized with an array of properties owned by the owner of this space, and 
    //      numUtilitiesOwned set to the number of utilities owned by this player
    public Utility()
    {
        super();
        super.price = 150; // price of a utility
        super.baseRent = 1; // the baseRent without the dice multplier

        ownerProperties = super.owner.getProperties(); // Get an array of properties this owner owns
        numUtilitiesOwned = this.getNumUtilitiesOwned(); // Get number of utilites owned by this owner
    }

    // PRE: Name is the name of the utility at the given board location
    // POST: Utility object is created with name set to the name
    public Utility(String name)
    {
        super();
        super.name = name; // set the name of this utilty
    }

    // POST: FCTVAL == Number of utlities owned by the current owner
    //                 Integer value in dollars where count >= 0 and count <= 2
    private int getNumUtilitiesOwned()
    {
        int count = 0;

        for (Property aProperty : ownerProperties) // loop through all properties owned by owner
        {
            if (aProperty instanceof Utility) // check if a property is a utility
            {
                count++; // increment count if owner owns another utility
            }
        }

        return count; // return count of utilities
    }

    // POST: FCTVAL == The current rent of landing on this utility
    public int getRent()
    {
        int diceRoll = 0; //TODO - Need to obtain the dice roll value from the player roll

        // check if number of utilities owned by the player is 1
        if (this.numUtilitiesOwned == 1)
        {
            return baseRent * (diceRoll*4); // rent is dice roll value * 4
        }
        // check if the number of utilities owned by the player is 2
        else if (this.numUtilitiesOwned == 2)
        {
            return baseRent * (diceRoll*10); // rent is dice roll value * 10
        }

        return 0; // utility isn't owned by a player, rent is 0
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
