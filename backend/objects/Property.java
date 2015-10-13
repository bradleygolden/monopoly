// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//

public abstract class Property extends BoardLocation
{
    protected final String[] options =  {"Purchase " + super.name, "Park for free", 
              "You owe " + Integer.toString(this.getRent())};

    protected Player owner; // The owner of the property
    protected int price; // The purchase price of the property
    protected int baseRent; // The cost of rent on a given space without improvements 

    // POST: A property object is created
    //       baseRent is set to 0, price is set to 0, owner is set to null
    //       Subclasses will initialize these values as needed
    public Property()
    {
        super();
        baseRent = 0;
        price = 0;
        owner = null;
    }

    public Property(String name, int address)
    {
        super(name, address);
    }

    // POST: FCTVAL = rent as an integer in dollar units for the current property
    public abstract int getRent();

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

    // PRE: player != null
    // POST: a string of possible player actions is returned
    public String getPossibleActions(Player player)
    {
        // check if space is unowned and player has enough cash to purchase property
        if (this.owner == null && player.getMoney() >= this.price)
        {
            // player can purchase or do nothing
        }
        // check if space is unowned and player doesn't have enough cash to purchase property
        else if (this.owner == null && player.getMoney() < this.price)
        {
            // player can't do anything
        }
        // check if the space is owned by someone other than the player
        else if (this.owner != null && this.owner != this.player)
        {
            // player must pay rent
        }
    }
}
