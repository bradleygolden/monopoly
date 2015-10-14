// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//

public class CornerSquare extends BoardLocation
{

    // POST: a CornerSquare object is created
    public CornerSquare()
    {
        super();
    }

    public CornerSquare(String name, int address)
    // PRE: name and address are valid
    //POST: CornerSquare will be made with the specified attributes
    {
        super(name, address);
    }

    // 
    @Override
    public String[] getPossibleActions(Player player)
    {
        //TODO - do this!
        return new String[] {""};
    }

    // POST: FCTVAL = name and address
    @Override
    public String toString() 
    {
        return "Name: " + super.name + " " + 
            "Address: " + super.address;
    }
}
