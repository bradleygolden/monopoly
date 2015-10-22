// Programmers: Stephen Selke, Bradley Golden, Chris Griffith
// Assignment:  Project 2, Monopoly
// Date:        October 21, 2015
// Description: This class creates a panel that contains information about a single property

import java.awt.*;
import javax.swing.*;

public class JPropertyInfoPanel extends JPanel
{
    protected JButton improve; // allow user to improve a property
    protected JButton sell; // allow user to sell an improvement
    protected JLabel propertyInfo; // string of the given proprty toString()

    // POST: a JPropertyInfo panel is created
    public JPropertyInfoPanel()
    {
        improve = new JButton("Improve");
        sell = new JButton("Sell");
    }

    // PRE: property != null
    // POST: a JPropertyInfoPanel is created with property.toString() added to the panel
    public JPropertyInfoPanel(Property property)
    {
        this(); 
        propertyInfo = new JLabel(property.simpleToString()); // print property info
        this.add(propertyInfo); // add property info to panel
    }

    // PRE: playerProperties may be null, 1, or > 1. property != null
    // POST: this panel is updated with the current property string and 
    //       an improve button
    public void update(Property property, Property[] playerProperties)
    {
        this.removeAll(); // clear this panel

        improve = new JButton("Improve"); // initialize new improve button
        //improve.setPreferredSize(new Dimension(40, 40)); // set dimesion of improve button
        sell = new JButton("Sell Improvement"); // initialize new sell improvement button
        //sell.setPreferredSize(new Dimension(40, 40)); // set dimesion of sell button
        propertyInfo = new JLabel(property.simpleToString()); // get property info
        this.add(propertyInfo); // add property label to this panel

        if (playerProperties == null)
            return; // player doesn't own properties

        // iterate through all player properties
        for (int i = 0; i < playerProperties.length; i++)
        {
            // if this property matches a player owned property
            // only add button if the property is a lot
            if (property == playerProperties[i] && property instanceof Lot)
            {
                // add improve button
                this.add(improve); 
                // add sell button
                this.add(sell);
                break;
            }
        }
    }
}
