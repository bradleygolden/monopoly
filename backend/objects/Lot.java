// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 9, 2015
// Description: This class models a Lot in monopoly (ie. property in 
//              a color-group, e.g. Boardwalk, Atlantic Ave, etc)  

import java.awt.Color;
import java.lang.String;

public class Lot extends Property
{
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

    public Lot(String name, int address, Color color, int price, int rent)
    {
        super();
        super.name = name;
        super.address = address;
        this.color = color;
        super.price = price;
        super.baseRent = rent;
    }

    public String toString()
        // POST: FCTVAL == string representation of this Lot
    {
        return "Name: " + super.name + " " +
            "Address: " + super.address + " " +
            "Color: " + this.color + " " + 
            "Price: " + super.price + " " +            
            "Rent:" + super.baseRent + " " +           
            "";
    }

    public void sell(Player player)
        // PRE:
        // POST:
    {

    }

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

    public int getRent()
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
}
