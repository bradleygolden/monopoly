// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//

public class Railroad extends Property
{
    private int numRailroadsOwned; // The number of railroads owned by the current owner of this RR
    private Property[] ownerProperties; // An array of properties owned by the player

    // POST: a railroad object is created with price = 200, baseRent = 25
    public Railroad()
    {
        super.price = 200; // The cost of a railroad
        super.baseRent = 25; // The baseRent without owning extra railroads
    }
    
    public Railroad(String name, int address)
    {
        super(name, address);
    }

    @Override
    public int getRent()
    {
        return baseRent;
    }

    // PRE: name is the name of the railroad and address is the distance from GO
    //      address = 5, 15, 25, or 35
    // POST: a railroad object is created with name = name and address = address
    public Railroad(String name, int address)
    {
        this();
        super.name = name;
        super.address = address;
    }
<<<<<<< HEAD

    // POST: FCTVAL == The current rent * number of railroads owned by this owner as an intenger 
    //                 currRent >= 0 and currRent <= 200
    public int getRent()
    {
        int currRent; // the current rent including additional railroads owned

        // Railroad rent is $25*(the number of railroads owned by the player owning this RR)
        //currRent = baseRent * numRailroadsOwned; // current rent including additional railroads

        //return currRent; // return current rent value
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

    // PRE: player has enough money to purchase the property
    // POST: purchaser's account value has been reduced by the cost of the property
    public int buy(Player buyer)
    {
        super.owner = buyer; // set the current owner to the buyer of this property
        buyer.withdraw(super.baseRent); // withdraw price of property from buyers cash
    }

    // POST: FCTVAL == A string containing the name, rent, and price of this property
    @Override
    public String toString()
    {
        return "Name: " + this.name + "\t" +
            "Rent: " + this.getRent() + "\t" +
            "Price: " + this.price + "\t" +
            "";
    }
=======
>>>>>>> 8a1f1faa629676ef5378088d9dabc06b069b7f2c
}
