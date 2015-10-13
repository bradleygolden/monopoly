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

    // PRE: name is the name of the railroad and address is the distance from GO
    //      address = 5, 15, 25, or 35
    // POST: a railroad object is created with name = name and address = address
    public Railroad(String name, int address)
    {
        this();
        super.name = name;
        super.address = address;
    }

    // POST: FCTVAL == return baseRent
    //                 baseRent >= 0
    @Override
    public int getRent(Player player)
    {
        // check if the current space is owned
        if (this.owner == null)
        {
            return 0; // this space is not owned
        }
        // check if the current player is the owner
        else if (player == this.owner)
        {
            return 0; // rent is 0 if the current player is the owner
        }
        // player will need to charge rent
        else if (player != this.owner)
        {
            return super.baseRent; // TODO apply railroad algorithm here...
        }
        // a boundary case has not been account for
        else
        {
            return -1; // an error has occurred
        }
    }
}
