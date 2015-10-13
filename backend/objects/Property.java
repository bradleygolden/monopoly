// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//

public abstract class Property extends BoardLocation
{
    protected static final String[] POSSIBLE_ACTIONS =  {"Purchase", "Park for free", "Pay rent"};
    protected Player owner; // The owner of the property
    protected int price; // The purchase price of the property
    protected int baseRent; // The cost of rent on a given space without improvements

    // POST: A property object is created
    //       baseRent is set to 0, price is set to 0, owner is set to null
    //       Subclasses will initialize these values as needed
    public Property()
    {
        baseRent = 0;
        price = 0;
        owner = null;
    }

    // POST: A property object is created with name set to name and address set to address
    public Property(String name, int address)
    {
        super(name, address);
    }

    // POST: FCTVAL = rent as an integer in dollar units for the current property
    public abstract int getRent(Player player);

    // POST: FCTVAL == return baseRent value property
    public int getBaseRent()
    {
        return this.baseRent;
    }

    // PRE: baseRent >=0
    //      this value should be the rent of a property without improvements
    public void setBaseRent(int baseRent)
    {
        this.baseRent = baseRent;
    }

    // POST: FCTVAL == price of a property as an integer value
    public int getPrice()
    {
        return this.price;
    }

    // PRE: price >= 0
    //      this value should be the price of the property
    public void setPrice(int price)
    {
        this.price = price;
    }

    // POST: FCTVAL == returns player object, this player is the owner of the current board location
    //                 owner can be initialized or null (no owner of this board location)
    public Player getOwner()
    {
        return this.owner;
    }

    // PRE: owner == null or owner = initialized Player object
    public void setOwner(Player owner)
    {
        this.owner = owner;
    }

    public boolean buy(Player buyer)
    {
        // check if buyer is the current owner of this property
        if (buyer == this.owner)
        {
            return false;
        }
        // check if the property is currently owned by another player
        if (this.owner != null)
        {
            return false;
        }
        // check if buyer has enough money to purchase the property
        else if (buyer.getMoney() < this.price)
        {
            return false;
        }
        // check if buyer has enough money to purhcase
        else if(buyer.getMoney() > this.price)
        {
            // charge buyer for property
            if (buyer.removeMoney(this.price) == false)
            {
                return false;
            }
            // add property to owner properties
            if (buyer.addProperty(this) == false)
            {
                return false;
            }
            // set the current propertie's owner instance to the buyer
            this.owner = buyer;

            return true;
        }
        // an error has occured
        else
        {
            System.out.println("Error in Property.buy(). Please check your boundary cases");
            return false;
        }
    }

    // PRE: player != null
    // POST: a string of possible player actions is returned
    public String[] getPossibleActions(Player player)
    {
        String[] possibleActions;
        // check if space is unowned and player has enough cash to purchase property
        if (this.owner == null && player.getMoney() >= this.price)
        {
            // player can either buy the property or park for free
            possibleActions = new String[2];
            possibleActions[0] = POSSIBLE_ACTIONS[0];
            possibleActions[1] = POSSIBLE_ACTIONS[1];
            return possibleActions;
        }
        // check if space is unowned and player doesn't have enough cash to purchase property
        else if (this.owner == null && player.getMoney() < this.price)
        {
            // player can't do anything
            possibleActions = new String[1];
            possibleActions[0] = POSSIBLE_ACTIONS[1];
            return possibleActions;
        }
        // check if the space is owned by someone other than the player
        else if (this.owner != null && this.owner != player)
        {
            // player must pay rent
            possibleActions = new String[1];
            possibleActions[0] = POSSIBLE_ACTIONS[2]; // player pays rent
            return possibleActions;
        }
        // check if the player is the owner of the space
        else if (this.owner == player)
        {
            // player can park for free
            possibleActions = new String[1];
            possibleActions[0] = POSSIBLE_ACTIONS[1]; // player can park for free
            return possibleActions;
        }
        else
        {
            // a case hasn't been accounted for
            possibleActions = new String[1];
            possibleActions[0] = "An error has occured in getPossibleActions. Boundary case not"
                + "accounted for";
            return possibleActions;
        }
    }
}
