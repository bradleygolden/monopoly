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

    public JPropertyInfoPanel()
    {
    }

    // PRE: name = property name, price = property price, owner = property owner, improvements = 
    //      number of improvemtns made to property, rent = rent amount
    // POST: a JPropertyInfoPanel is created with 5 components:
    //       name JLabel
    //       price JLabel
    //       owner JLabel
    //       imrpovements JLabel
    //       rent JLabel
    public JPropertyInfoPanel(String name, String price, String owner, String improvements, String rent)
    {
        this();

        this.name = new JLabel(name);
        this.price = new JLabel(price);
        this.owner = new JLabel(owner);
        this.improvements = new JLabel(improvements);
        this.rent = new JLabel(rent);

        this.add(this.name);
        this.add(this.price);
        this.add(this.owner);
        this.add(this.improvements);
        this.add(this.rent);
    }

    // PRE: see following constructor
    //      manageable -- indicates whether this property label should include manage buttons
    // POST: see following constructor
    //       improve -- JButton is created for the user to improve their property
    public JPropertyInfoPanel(String name, String price, String owner, String improvements, String rent,
            boolean manageable)
    {
        this(name, price, owner, improvements, rent); // call previous constructor

        if (manageable) // this property can be managed
        {
            improve = new JButton("Improve"); // create improve button for user
            this.add(improve); // add button to panel
        }
    }
}
