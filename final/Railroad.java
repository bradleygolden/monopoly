// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description: This class models a railroad in monopoly (ie. Reading Railroad, etc..)

public class Railroad extends Property
{
    //private Property[] ownerProperties; // An array of properties owned by the player

    //private int numRailroadsOwned;      // The number of railroads owned 
                                          //   by the current owner of this RR
    public Railroad()
    // POST: a railroad object is created with price = 200, baseRent = 25
    {   
        super(); 
        super.price = 200;      // The cost of a railroad
        super.baseRent = 25;    // The baseRent without owning extra railroads
    }

    public Railroad(String name, int address)
    // PRE:  name is the name of the railroad and address is the distance from GO
    //       address = 5, 15, 25, or 35
    // POST: a railroad object is created with name set to name, address set to 
    //       address, price set to 200, and baseRent set to 25
    {
        super(name, address);
        super.price = 200;     
        super.baseRent = 25; 
    }

    @Override
    public int getRent(Player player)
    // PRE:  player is initialized
    // POST: FCTVAL == rent dependent upon number of railroads owned by player
    {
        if (this.owner == null)             // this RR is not owned
        {
            return 0;                       
        }
        else if (player == this.owner)      // rent is 0 if the current player owns the RR
        {
            return 0;                       
        }
        else if (player != this.owner)      // player owes rent
        {
            Property[] prop;
            int count;

            prop = this.owner.getProperties();
            count = 0;

            for(int i = 0; i < prop.length; i++)
            {
                if(prop[i].getName() == "Reading Railroad" ||         // count number of railroads
                   prop[i].getName() == "Pennsylvania Railroad" ||    // owned by this player
                   prop[i].getName() == "B. & O. Railroad" ||         
                   prop[i].getName() == "Short Line")
                {
                    count++;
                }
            }
   
            if(count == 2)                    // this railroad owner owns 2 railroads
            {
                return super.baseRent * 2;
            }
            else if(count == 3)               // this railroad owner owns 3 railroads
            {
                return super.baseRent * 4;
            }
            else if(count == 4)               // this railroad owner owns all railroads
            {
                return super.baseRent * 8;
            }
            else                              // this is the only railroad owned
            {
                return super.baseRent;
            }
        }
        else                                // an error has occurred
        {
            return -1; 
        }
    }
}
