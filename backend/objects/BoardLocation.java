// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description:
//

public class BoardLocation
{
    protected int address; // number of spaces from Go
    protected String name; // name of current location

    public BoardLocation()
    //POST: sets address and name to nothing
    {
        address = 0;
        name = "";
    }

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
        return "Name: " + name + " " +
            "Address: " + address;
    }

}
