// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//

public class BoardLocation 
{
    protected final int address; // number of spaces from Go
    protected final String name; // name of current location

    // POST: sets address to address, and the name
    //       of the board location to name
    public BoardLocation(String name, int address)
    {
        this.name = name;
        this.address = address;
    }

    // POST: FCTVAL = the distance from Go
    public int getAddress() 
    {
        return address;
    }

    // POST: FCTVAL = the name of this square
    public String getName() 
    {
        return name;
    }

    // POST: FCTVAL = the name of the square and its
    //       distance from Go
    @Override
    public String toString() 
    {
        return name + ", " + address;
    }

}
