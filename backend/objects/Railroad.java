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
        super.price = 200; // The cost of a railroad
        super.baseRent = 25; // The baseRent without owning extra railroads

        ownerProperties = super.owner.getProperties(); // Get an array of properties this owner owns

        // Get number of railroads owned by this owner
        numRailroadsOwned = this.getNumRailroadsOwned();     
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
}
