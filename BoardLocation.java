// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description: This class models any board location in the game monopoly 

public abstract class BoardLocation 
{
    protected int address;      // number of spaces from Go
    protected String name;      // name of current location

    public BoardLocation()
    //POST: A BoardLocation is created with address 
    //      set to zero and name set to empty
    {
        this.address = 0;
        this.name = "";
    }

    public BoardLocation(String name, int address)
    // POST: A BoardLocation object is created where address is set to
    //       address, and name of the board location set to name
    {
        this.name = name;
        this.address = address;
    }

    public int getAddress() 
    // POST: FCTVAL == the board location address (ie. the distance from Go)
    {
        return address;
    }

    public String getName() 
    // POST: FCTVAL == the name of this board location
    {
        return name;
    }

    abstract String[] getPossibleActions(Player player);
    //POST: return array of possible actions for player

    @Override
    public String toString() 
    // POST: FCTVAL == string representation of this board location
    {
        return "Name: " + name + " Address: " + address;
    }
}
