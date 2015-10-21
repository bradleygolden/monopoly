// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description: This class models a Utility location in monopoly (ie. Water Works)

public class Utility extends Property
{
    //private int numUtilitiesOwned;      // The number of utilities owned by the current owner
    //private Property[] ownerProperties; // An array of properties owned by the owner

    public Utility()
    //POST: Utility object is created with price set to 150, baseRent set to 1, ownerProperties
    //      initialized with an array of properties owned by the owner of this space, and 
    //      numUtilitiesOwned set to the number of utilities owned by this player
    {
        super();
        super.price = 150;             // price of a utility
        super.baseRent = 1;            // the baseRent without the dice multplier

       // ownerProperties = super.owner.getProperties();
       // numUtilitiesOwned = this.getNumUtilitiesOwned(); 
    }

    public Utility(String name, int address)
    // PRE:  name is the name of the utility at the given board location, address >= 0
    // POST: Utility object is created with name set to the name and address set to address
    {
        super(name, address);
        super.price = 150;             // price of a utility
        super.baseRent = 1;            // the baseRent without the dice multplier
        
        // ownerProperties = super.owner.getProperties();
        // numUtilitiesOwned = this.getNumUtilitiesOwned(); 
    }

/*
    private int getNumUtilitiesOwned()
    // POST: FCTVAL == Number of utlities owned by the current owner
    //                 Integer value in dollars where count >= 0 and count <= 2
    {
        int count = 0;

        for (Property aProperty : ownerProperties) // loop through all properties owned by owner
        {
            if (aProperty instanceof Utility)      // check if a property is a utility
            {
                count++;                           // increment count if owner owns another utility
            }
        }

        return count;                              // return count of utilities
    }
*/

    @Override
    public int getRent(Player player)
    {
        return -1;
    }

    @Override
    public int getRent(Player player, int diceValues)
    // PRE:  player is initialized and 1 <= diceValues >= 12
    // POST: FCTVAL == The current rent for landing on this utility
    {
        if(this.owner == null)           // no one owns this utility thus no rent is paid
        {   
            return 0;
        }   
        else if(this.owner == player)    // current player owns this utility
        {   
            return 0;
        }   
        else if(this.owner != player)    // current player does not own utility
        {               
            Property[] prop;
            int count;

            prop = this.owner.getProperties();
            count = 0;

            for(int i = 0; i < prop.length; i++)
            {   
                if(prop[i].getName().equals("Water Works") ||     // count number of utilities
                   prop[i].getName().equals("Electric Company"))  // owned by this player
                {   
                    count++;
                }   
            }   
   
            if(count == 2)                    // this utility owner owns 2 utilities
            {   
                return super.baseRent * (diceValues*10);
            }   
            else                              // owner only owns one utility
            {
                return super.baseRent * (diceValues*4);
            }
        }   
        else                                  // an error has occured
        {   
            return -1; 
        } 
    }

    public String toString()
    // POST: FCTVAL == string representation of a utility
    {
        return super.toString();
    }

    public String simpleToString()
    // POST: FCTVAL == simpler string representation of this lot 
    //       (Name, Owner, Price, Rent)
    {   
        return "Name: "  + this.name     + " " +
               "Owner: " + (this.owner == null ? "Bank" : this.owner)    + " " +
               "Price: " + this.price    + " " +
               "Rent: "  + this.baseRent;
    }   

}
