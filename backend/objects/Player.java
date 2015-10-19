// Programmers:  Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 6, 2015
// Description: 
//              

public class Player 
{
    private int money;              // amount of money a player has
    private BoardLocation location; // track the location of a player on the board
    private String token;           // piece that represents player
    private Property[] properties;  // list of properties owned by the player

    public Player() 
    //POST:  a new player will be created with $0, starting at Go, no properties, token: shoe
    {
        money = 0;
        token = "Boot";
        properties = null;
    }

    public Player(int money, String token, BoardLocation location) 
    // PRE:  money >= 0 and token is a valid token string location is valid
    //POST:  a new player will be created with the amount of money specified
    //       and the token from the token string. And start position is location
    {
        this();
        moveTo(location);
        this.money = money;
        this.token = token;
    }

    public void moveTo(BoardLocation location) 
    {
        this.location = location;
    }

    public int getMoney()
    //POST: returns in $ how much money player has
    {
        return money;
    }

    public Property[] getProperties()
    //POST: returns array of properties
    {
        return properties;
    }

    public String propertiesToString()
    //POST: returns list of properties owned comma sperated
    {
        String acc = "";
        if(properties == null)
        {
            return "";
        }
        for(Property p : properties) // adds up properties
        {
            acc += p.toString() + ", ";
        }
        return acc;
    }

    public BoardLocation getBoardLocation()
    //POST: returns player location
    {
        return location;
    }

    public String getToken()
    //POST: returns token
    {
        return token;
    }

    public boolean addProperty(Property property)
    // PRE: property is a valid property
    //POST: property will be added to the list of players properties
    {
        if(properties == null) 
        {
            Property[] newPropertyArray = new Property[] {property};
            property.setOwner(this);
            properties = newPropertyArray;
            return true;
        }
        Property[] newPropertyArray = new Property[properties.length + 1]; // new array
        for(int i = 0; i < properties.length; i++) // copy over old array
        {
            newPropertyArray[i] = properties[i];
        }
        newPropertyArray[properties.length] = property;
        properties = newPropertyArray;
        newPropertyArray[properties.length-1].setOwner(this);
        return true;
    }

    public boolean addMoney(int money)
    // PRE: money is > 0
    //POST: players money will be added on to
    {
        if(money > 0) 
        { // money > 0 add this amount
            this.money += money;
            return true;
        }
        else 
        { // can't add this amount
            return false;
        }
    }

    public boolean removeMoney(int money) 
    // PRE: money > 0
    //POST: money will be removed from player if there is enough money
    //      otherwise, FUNCVAL = false
    {
        if(money > 0 && this.money - money >= 0) 
        { // money can and will be removed
            this.money -= money;
            return true;
        }
        else
        { // not enough funds or money is a negative number
            return false;
        }
    }

    @Override
    public String toString() 
    //POST: will return string represnetation of player
    {
        String s = "Player \"" + token + "\" with $" + money + ", at " + location.toString();
        s += " owns: ";
        if(properties == null) 
        {
            return s;
        }
        for(Property p : properties) // adds up properties
        {
            s += p.toString() + "\n";
        }
        return s;
    }
}
