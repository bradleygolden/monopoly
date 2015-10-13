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
    public int getRent()
    {
        return super.baseRent;
    }

    // PRE: player is initialized
    // POST: FCTVAL == array of options player has upon landing on
    //                 this space, to be used in a menu in a user interface
    public String getPossibleActions(Player player)
    {
        // Does nothing yet
        return "";
    }
}
