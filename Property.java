// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description: This class models a property in monopoly (ie. any lot, railroad, & utility) 

public abstract class Property extends BoardLocation
{
    protected static final String[] POSSIBLE_ACTIONS =  {"Purchase", "Free Parking", "Pay Rent"};

    protected Player owner;         // The owner of the property
    protected int price;            // The purchase price of the property
    protected int baseRent;         // The cost of rent on a given space without improvements

    public Property()
    // POST: A property object is created
    //       baseRent is set to 0, price is set to 0, owner is set to null
    //       Subclasses will initialize these values as needed
    {
        super();
        this.baseRent = 0;
        this.price = 0;
        this.owner = null;
    }

    public Property(String name, int address)
    // POST: A property object is created with name set to name and address set to address
    {
        super(name, address);
        this.baseRent = 0;
        this.price = 0;
        this.owner = null;
    }

    public abstract int getRent(Player player);
    // POST: FCTVAL == rent as an integer in dollar units for the current property
    
    public abstract int getRent(Player player, int diceValues);
    // POST: FCTVAL == rent as an integer in dollar units for the current property

    public int getBaseRent()
    // POST: FCTVAL == return baseRent value of property
    {
        return this.baseRent;
    }

    public void setBaseRent(int baseRent)
    // PRE:  baseRent >=0 dollars
    // POST: this baseRent set to baseRent
    {
        // this value is the rent of a property without improvements
        this.baseRent = baseRent;
    }

    public int getPrice()
    // POST: FCTVAL == price of a property
    {
        return this.price;
    }

    public void setPrice(int price)
    // PRE:  price >= 0 dollars
    // POST: this property price set to price
    {
        // this value is the price of the property
        this.price = price;
    }

    public Player getOwner()
    // POST: FCTVAL == returns player object, this player is the owner of the current board 
    //       location owner can be initialized or null (no owner of this board location)
    {
        return this.owner;
    }

    public void setOwner(Player owner)
    // PRE:  owner == null or an initialized Player object
    // POST: owner set to new owner
    {
        this.owner = owner;
    }

    public boolean buy(Player buyer)
    // PRE:  buyer is initialized
    // POST: FCTVAL == true if player can buy this property, otherwise false
    {
        if (buyer == this.owner)    // check if buyer is the current owner
        {
            return false;
        }
        if (this.owner != null)     // check if the property is currently owned by another player
        {
            return false;
        }
        else if (buyer.getMoney() < this.price)  // buyer does not have enough money to purchase
        {
            return false;
        }
        else if(buyer.getMoney() > this.price)   // buyer has enough money to purchase
        {
            if (buyer.removeMoney(this.price) == false)  // charge buyer for property
            {
                return false;
            }
            if (buyer.addProperty(this) == false)        // add property to new owner
            {
                return false;
            }
            
            // set the current property owner instance to the buyer
            this.owner = buyer;

            return true;
        }
        else                                            // an error has occured
        {
            System.out.println("Error in Property.buy(). Please check your boundary cases");
            return false;
        }
    }

    public String[] getPossibleActions(Player player)
    // PRE: player != null
    // POST: a string of possible player actions is returned
    {
        String[] possibleActions;
        
        if (this.owner == null &&                      // check if space is unowned and player 
            player.getMoney() >= this.price)           // has enough cash to purchase property
        {
            // player can either buy the property or park for free
            possibleActions = new String[2];
            possibleActions[0] = POSSIBLE_ACTIONS[0];
            possibleActions[1] = POSSIBLE_ACTIONS[1];
            return possibleActions;
        }
        else if (this.owner == null &&                 // check if space is unowned and player
                 player.getMoney() < this.price)       // doesn't have enough cash to purchase
        {
            // player can't do anything
            possibleActions = new String[1];
            possibleActions[0] = POSSIBLE_ACTIONS[1];
            return possibleActions;
        }
        else if (this.owner != null &&                 // check if the space is owned by someone
                 this.owner != player)                 // other than the player
        {
            // player must pay rent
            possibleActions = new String[1];
            possibleActions[0] = POSSIBLE_ACTIONS[2];  // player pays rent
            return possibleActions;
        }
        else if (this.owner == player)                 // check if the player is the owner
        {
            // player can park for free
            possibleActions = new String[1];
            possibleActions[0] = POSSIBLE_ACTIONS[1];  // player can park for free
            return possibleActions;
        }
        else                                           // an error occurred
        {
            possibleActions = new String[1];
            possibleActions[0] = "An error has occured in getPossibleActions. " 
                                  + "Boundary case not accounted for";
            return possibleActions;
        }
    }

    public String toString()
    // POST: FCTVAL == string representation of this property
    {
        return super.toString() + " Price: " + this.price + 
                                  " Rent: "  + this.baseRent;
    }
}
