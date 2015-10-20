import java.awt.*;
import javax.swing.*;

public class JPropertyInfoPanel extends JPanel
{
    protected JLabel name; // name of the property
    protected JLabel price; // price of the property
    protected JLabel owner; // owner of the property
    protected JLabel improvements; // number of improvements made
    protected JLabel rent; // rent of the current property
    protected JButton improve; // allow user to improve a property
    protected JLabel propertyInfo; // string of the given proprty toString()

    public JPropertyInfoPanel()
    {
        // do nothing
    }

    public JPropertyInfoPanel(Property property)
    {
        this();
        propertyInfo = new JLabel(property.toString());
        this.add(propertyInfo);
    }

    // PRE: see following constructor
    //      manageable -- indicates whether this property label should include manage buttons
    // POST: see following constructor
    //       improve -- JButton is created for the user to improve their property
    public void oldFunc(String name, String price, String owner, String improvements, String rent,
            boolean manageable)
    {
        if (manageable) // this property can be managed
        {
            improve = new JButton("Improve"); // create improve button for user
            this.add(improve); // add button to panel
        }
    }
}
