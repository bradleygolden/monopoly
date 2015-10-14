// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 9, 2015
// Description: This class models a Lot in monopoly (ie. property in 
//              a color-group, e.g. Boardwalk, Atlantic Ave, etc)  

import java.awt.Color;
import java.lang.String;

public class Lot extends Property
{
    private static final String[] POSSIBLE_ACTIONS =  {"Purchase", "Park for free", 
                                                       "Pay rent", "Purchase improvement", 
                                                       "Sell improvement"}; // Actions List

    private Color color;                 // The color of a given group of properties
    private int[] rent;                  // Rent Structure of a lot based on numImprovements
    private int   improvementCost;       // The cost of improving the current property
    private int   numImprovements;       // The number of houses and/or hotel on a given lot

    public Lot()
    // POST: A default lot object is created with the color set to gray, 
    //       improvementCost set to 0, numImprovements set to 0, and rent array
    //       initialized to hold six dollar values
    {
        this(new Color(255, 255, 255), 0);       // default color is set to white 
    }

    public Lot(Color color, int improvementCost)
    // PRE:  color is initialized, improvmentCost >= 0 in dollars 
    // POST: A lot object is created with color set to color, improvementCost 
    //       set to improvementCost, numImprovements set to 0, and rent array
    //       initialized to hold six dollar values
    {
        super();                                 // call superclass constructor
        this.color = color;
        this.improvementCost = improvementCost;  // never changes after being set
        this.numImprovements = 0;
        this.rent = new int[6];                  // initialized to zero by default
    }

    public Lot(String name, int address, Color color, int price, int rent, int improvementCost)
    // PRE:  name and color is initialized, address >= 0 with units as the number of 
    //       spaces from GO, price >= 0 dollars, and rent >=0 dollars.
    // POST: A lot object is created with super.name set to name, super.address set 
    //       to address, color set to color, price set to price, and rent set to rent
    {
        super(name, address);
        this.color = color;
        this.improvementCost = improvementCost;  // never changes after being set
        this.numImprovements = 0;
        this.rent = new int[6];                  // initialized to zero by default
        super.price = price;
        super.baseRent = rent;
        super.owner = null;
    }

    public Lot(String name, int address, Color color, int price, int rent, int improvementCost,
               int oneImpr, int twoImpr, int threeImpr, int fourImpr, int fiveImpr)
    // PRE:  name and color initialized, address >= 0 where the units are the number of 
    //       spaces from GO, and price, rent, improvementCost, zeroImpr, oneImpr, twoImpr,
    //       threeImpr, fourImpr, and fiveImpr are all >= 0 dollars.
    // POST: A lot object is created with name set to name, address set to address, 
    //       color set to color, price set to price, rent set to rent, improvementCost
    //       set to improvementCost, and the rent at index numImprovements set to 
    //       corresponding improvement value
    {
        this(name, address, color, price, rent, improvementCost);
        this.rent[0] = super.baseRent;
        this.rent[1] = oneImpr;
        this.rent[2] = twoImpr;
        this.rent[3] = threeImpr;
        this.rent[4] = fourImpr;
        this.rent[5] = fiveImpr;
    }

    // TODO: Add rent prices for each lot improvement
    public String toString()
    // POST: FCTVAL == string representation of this Lot
    {
        return "Name: "    + this.name     + " " +
               "Address: " + this.address  + " " +
               "Color: "   + this.color    + " " + 
               "Price: "   + this.price    + " " +            
               "Rent:"     + this.baseRent + " " +           
               "Improvement Cost: " + this.improvementCost + " " + 
               "One House: " + this.rent[1] + " " + 
               "Two Houses: " + this.rent[2] + " " + 
               "Three Houses: " + this.rent[3] + " " + 
               "Four Houses: " + this.rent[4] + " " + 
               "Hotel: " + this.rent[5] + " " + 
               "";
    }

    //public void sell(Player player)
    // PRE:
    // POST:
    //{
    //
    //}

    public void sellImprovement()
        // POST: class member numImprovements is decreased by one if numImprovements
        //       for this lot has not reached zero
    {
        if(this.numImprovements > 0)   // cannot sell improvement if lot is not improved
            this.numImprovements--;
    }

    public void improve()
        // POST: class member numImprovments is increased by one if max improvements
        //       for this lot has not been reached
    {
        if(this.numImprovements <= 5)  // max number of improvements has not been reached
            this.numImprovements++;
    }

    public int getRent(Player player)
    // POST: FCTVAL == price of rent in dollars based on the numImprovements on lot
    {
        return this.rent[this.numImprovements];
    }

    public Color getColor()
        // POST: FCTVAL == color of this lot
    {
        return this.color;
    }

    public int getImprovementCost()
        // POST: FCTVAL == improvementCost (ie. cost to improve lot) 
    {
        return this.improvementCost;
    }

    public int getNumImprovements()
        // POST: FCTVAL == numImprovements on this lot
    {
        return this.numImprovements;
    }

    public void setRent(int rent, int numImprovements)
        // PRE:  rent >= 0 in dollars, and numImprovements >= 0 and < 6
        // POST: class member rent array at index numImprovements is set to rent
    {
        this.rent[numImprovements] = rent;
    }

    public void setColor(Color color)
        // PRE:  color is initialized
        // POST: class member color is modified to color
    {
        this.color = color;
    }

    public void setImprovementCost(int improvementCost)
        // PRE:  improvementCost >= 0 in dollars
        // POST: class member improvementCost is set to improvementCost
    {
        this.improvementCost = improvementCost; 
    }

    public String[] getPossibleActions(Player player)
    // PRE:  player is initialized
    // POST: FCTVAL == string of possible player actions
    {   
        String[] possibleActions;                   // Gather strings of possible player actions

        if (this.owner == null &&                              // lot is unowned and player
            player.getMoney() >= this.price)                   //     has enough money to purchase
        {                                                          
            // player can either buy the property or park for free
            possibleActions = new String[2];
            possibleActions[0] = POSSIBLE_ACTIONS[0];
            possibleActions[1] = POSSIBLE_ACTIONS[1];
            return possibleActions;
        }   
        else if (this.owner == null &&                         // lot is unowned and player         
                 player.getMoney() < this.price)               //    does not have enough money
        {                                                            
            // player can't do anything and parks for free
            possibleActions = new String[1];
            possibleActions[0] = POSSIBLE_ACTIONS[1];
            return possibleActions;
        }   
        else if (this.owner != null &&                         // lot is owned by someone
                 this.owner != player)                         //   other than player
        {   
            // player must pay rent
            possibleActions = new String[1];
            possibleActions[0] = POSSIBLE_ACTIONS[2];
            return possibleActions;
        }
        else if (this.owner == player)                         // player owns this lot 
        {
            // player can park for free
            possibleActions = new String[1];
            possibleActions[0] = POSSIBLE_ACTIONS[1];
            return possibleActions;
        }
        else                                                   // all options exhausted 
        {   
            // a case hasn't been accounted for
            possibleActions = new String[1];
            possibleActions[0] = "An error has occured in getPossibleActions. " 
                                 + "Boundary case not accounted for!";
            return possibleActions;
        }   
    }   
}
