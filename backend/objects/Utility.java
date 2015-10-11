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
    }

    // PRE: Name is the name and address of the utility at the given board location
    //      address = 12 or 28
    // POST: Utility object is created with name = name and address = address
    public Utility(String name, int address)
    {
        super();
        super.name = name; // set the name of this utilty
        super.address = address; // set the address of this utilty
    }

    // POST: FCTVAL == The current rent of landing on this utility
    public int getRent()
    {
        return baseRent;
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

    // POST: A string containing the name, rent, and address of the utility at this boardlocation
    @Override 
    public String toString()
    {
        return "Name: " + this.name + "\t" +
            "Address: " + this.getRent() + "\t" +
            "Rent:" + this.getRent() + "\t" +
            "";
    }
}
