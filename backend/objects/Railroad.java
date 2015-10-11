// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//

public class Railroad extends Property
{
    private int numRailroadsOwned; // The number of railroads owned by the current owner of this RR
    private Property[] ownerProperties; // An array of properties owned by the player

    public Railroad()
    {
        super();
        super.price = 200; // The cost of a railroad
        super.baseRent = 25; // The baseRent without owning extra railroads

        ownerProperties = super.owner.getProperties(); // Get an array of properties this owner owns

        // Get number of railroads owned by this owner
        numRailroadsOwned = this.getNumRailroadsOwned();     
    }

    // PRE: An owner of type Player
    // POST: FCTVAL == count >= 0 and count <=4 (4 being the number of RR's on the board)
    //       Count represents the number of railroads owned by the current player
    private int getNumRailroadsOwned()
    {
        int count = 0; // count the properties that are a railroad

        for (Property aProperty : ownerProperties) // loop through properties in owner properties
        {
            if (aProperty instanceof Railroad) // check if a property is an instance of railroad
            {
                count++; // increment count if railraod instance is found
            }
        }

        return count; // return number of railroads counted
    }

    // POST: FCTVAL == The current rent * number of railroads owned by this owner as an intenger 
    //                 currRent >= 0 and currRent <= 200
    public int getRent()
    {
        int currRent; // the current rent including additional railroads owned

        // Railroad rent is $25*(the number of railroads owned by the player owning this RR)
        currRent = baseRent * numRailroadsOwned; // current rent including additional railroads

        return currRent; // return current rent value
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

    // PRE: player has enough money to purchase the property
    // POST: purchaser's account value has been reduced by the cost of the property
    public int buy(Player buyer)
    {
        super.owner = buyer; // set the current owner to the buyer of this property
        buyer.withdraw(super.baseRent); // withdraw price of property from buyers cash
    }

    // POST: FCTVAL == A string containing the name, rent, and price of this property
    public void toString()
    {
        return "Name: " + this.name + "\t" +
            "Rent: " + this.getRent() + "\t" +
            "Price: " + this.price + "\t" +
            "";
    }
}
